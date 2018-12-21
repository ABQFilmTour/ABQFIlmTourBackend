package edu.cnm.deepdive.abq_film_tour_backend.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;

@Component
public class GoogleTokenServices implements ResourceServerTokenServices {

  @Value("${oauth.clientId}")
  private String clientId;

  private UserRepository userRepository;

  private GoogleTokenServices(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  private final AccessTokenConverter converter = new DefaultAccessTokenConverter();

  @Override
  public OAuth2Authentication loadAuthentication(String idTokenString)
      throws AuthenticationException, InvalidTokenException {
    try {
      HttpTransport transport = new NetHttpTransport();
      JacksonFactory jsonFactory = new JacksonFactory();
      GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
          .setAudience(Collections.singletonList(clientId))
          .build();
      GoogleIdToken idToken = verifier.verify(idTokenString);
      if (idToken != null) {
        Payload payload = idToken.getPayload();
        handlePayload(payload);
        Collection<GrantedAuthority> grants =
            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
        //(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"));
        Authentication base =
            new UsernamePasswordAuthenticationToken(payload.getSubject(), idTokenString, grants);
        OAuth2Request request = converter.extractAuthentication(payload).getOAuth2Request();
        return new OAuth2Authentication(request, base);
      } else {
        throw new BadCredentialsException(idTokenString);
      }
    } catch (BadCredentialsException e) {
      throw new InvalidTokenException("Bad token");
    }
    catch (GeneralSecurityException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void handlePayload(Payload payload) {
    String userId = payload.getUserId();
    String name = payload.get("name").toString();
    String email = payload.getEmail();
    GoogleUser user = userRepository.findByGoogleId(userId);
    if (user == null) { //User has not been put into the database yet
      GoogleUser newUser = new GoogleUser();
      newUser.setGoogleId(userId);
      newUser.setGoogleName(name);
      newUser.setGmailAddress(email);
      newUser.setBanned(false);
      userRepository.save(newUser);
    }
  }

  @Override
  public OAuth2AccessToken readAccessToken(String s) {
    return null;
  }

}