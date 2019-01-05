package edu.cnm.deepdive.abq_film_tour_backend.controller;

final class Constants {

  static final String FILM_LOCATION_LIST_SUMMARY = "";
  static final String FILM_LOCATION_LIST_DESC = "Gets all film locations, ordered by the time of creation.";
  static final String FILM_LOCATION_GET_SUMMARY = "";
  static final String FILM_LOCATION_GET_DESC = "Gets a single film location by its internal ID.";
  static final String FILM_LOCATION_POST_SUMMARY = "";
  static final String FILM_LOCATION_POST_DESC = "Posts a new film location to the film locations endpoint. Should include coordinates, a site name, a Google ID, and an associated Production at the minimum.";
  static final String FILM_LOCATION_DELETE_SUMMARY = "";
  static final String FILM_LOCATION_DELETE_DESC = "Restricted to superuser privileges or above. Deletes a film location by its internal ID.";
  static final String FILM_LOCATION_PATCH_SUMMARY = "";
  static final String FILM_LOCATION_PATCH_DESC = "Restricted to superuser privileges or above. Patches a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the image should be included in the body. Can be used to approve a location submission.";

  static final String IMAGE_LIST_SUMMARY = "";
  static final String IMAGE_LIST_DESC = "Gets all of the images on a film location endpoint, ordered by the time of creation.";
  static final String IMAGE_GET_SUMMARY = "";
  static final String IMAGE_GET_DESC = "Gets a single image on a film location endpoint, referenced by its internal ID";
  static final String IMAGE_POST_SUMMARY = "";
  static final String IMAGE_POST_DESC = "Posts a new image to a film location endpoint. Should contain a Google ID for the submitter and the URL the image is located at.";
  static final String IMAGE_DELETE_SUMMARY = "";
  static final String IMAGE_DELETE_DESC = "Restricted to superuser privileges or above. Deletes a single image on a film location endpoint, referenced by its internal ID.";
  static final String IMAGE_PATCH_SUMMARY = "";
  static final String IMAGE_PATCH_DESC = "Restricted to superuser privileges or above. Patches an image from the images endpoint on a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the image should be included in the body. Can be used to approve an image submission.";

  static final String USER_COMMENT_LIST_SUMMARY = "";
  static final String USER_COMMENT_LIST_DESC = "Gets all of the user comments on a film location endpoint, ordered by the time of creation.";
  static final String USER_COMMENT_GET_SUMMARY = "";
  static final String USER_COMMENT_GET_DESC = "Gets a single user comment on a film location endpoint, referenced by its internal ID";
  static final String USER_COMMENT_POST_SUMMARY = "";
  static final String USER_COMMENT_POST_DESC = "Posts a new user comment to a film location endpoint. Should contain a Google ID for the author and the text content of the comment.";
  static final String USER_COMMENT_DELETE_SUMMARY = "";
  static final String USER_COMMENT_DELETE_DESC = "Restricted to superuser privileges or above. Deletes a single user comment on a film location endpoint, referenced by its internal ID.";
  static final String USER_COMMENT_PATCH_SUMMARY = "";
  static final String USER_COMMENT_PATCH_DESC = "Restricted to superuser privileges or above. Patches a user comment from the user comments endpoint on a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the user comment should be included in the body. Can be used to approve a comment submission. ";

  static final String USER_LIST_SUMMARY = "";
  static final String USER_LIST_DESC = "Admin access only. Gets all users, ordered alphabetically by the name on their account.";
  static final String USER_GET_SUMMARY = "";
  static final String USER_GET_DESC = "Admin access only. Gets a user from the users endpoint, referenced by their internal ID.";
  static final String USER_POST_SUMMARY = "";
  static final String USER_POST_DESC = "Admin access only. Posts a new user to the users endpoint. Should include a Google ID, full name, and gmail address.";
  static final String USER_DELETE_SUMMARY = "";
  static final String USER_DELETE_DESC = "Admin access only. Deletes a user from the users endpoint, referenced by their internal ID.";
  static final String USER_PATCH_SUMMARY = "";
  static final String USER_PATCH_DESC = "Admin access only. Patches a user from the users endpoint. All data will be overwritten - current fields to stay the same must be included as well. Can be used to ban or unban a user.";

  static final String PRODUCTION_LIST_SUMMARY = "";
  static final String PRODUCTION_LIST_DESC = "Gets all of the productions on the productions endpoint, ordered alphabetically by their title.";
  static final String PRODUCTION_GET_SUMMARY = "";
  static final String PRODUCTION_GET_DESC = "Gets a single production from the productions endpoint, referenced by its internal ID.";
  static final String PRODUCTION_POST_SUMMARY = "";
  static final String PRODUCTION_POST_DESC = "Restricted to superuser privileges or above. ";
  static final String PRODUCTION_DELETE_SUMMARY = "";
  static final String PRODUCTION_DELETE_DESC = "Restricted to superuser privileges or above. ";
  static final String PRODUCTION_PATCH_SUMMARY = "";
  static final String PRODUCTION_PATCH_DESC = "Restricted to superuser privileges or above. ";
  static final String PRODUCTION_POSTER_SUMMARY = "Retrieves a poster image for the production.";
  static final String PRODUCTION_POSTER_DESC = "Retrieves a poster image relayed its source on the OMDb API. Image is returned as a raw StreamingBodyResponse to be deserialized.";

  static final String RESPONSE_SUCCESSFUL = "Operation successful.";
  static final String RESPONSE_400 = "Failure to parse request. Double check any IDs.";
  static final String RESPONSE_401 = "Failure to authorize. Advised to check authorization token header.";
  static final String RESPONSE_403 = "Forbidden to access. User has insufficient privileges or is banned from using the service.";
  //TODO 404 capability should be added, at the moment "No value present" throws a 500.
  static final String RESPONSE_500 = "Internal server error. This is frequently thrown by unexpected exceptions.";

}