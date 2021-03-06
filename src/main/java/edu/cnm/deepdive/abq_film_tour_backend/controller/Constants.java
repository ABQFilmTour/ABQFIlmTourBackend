package edu.cnm.deepdive.abq_film_tour_backend.controller;

final class Constants {

  static final String FILM_LOCATION_LIST_SUMMARY = "Gets all film locations. ";
  static final String FILM_LOCATION_LIST_DESC = "Gets all film locations, ordered by the time of creation.";
  static final String FILM_LOCATION_GET_SUMMARY = "Gets a film location.";
  static final String FILM_LOCATION_GET_DESC = "Gets a single film location by its internal ID.";
  static final String FILM_LOCATION_POST_SUMMARY = "Posts a new film location.";
  static final String FILM_LOCATION_POST_DESC = "Posts a new film location to the film locations endpoint. Should include coordinates, a site name, a Google ID, Google name, profile picture URL, and an associated Production at the minimum.";
  static final String FILM_LOCATION_DELETE_SUMMARY = "Deletes a film location.";
  static final String FILM_LOCATION_DELETE_DESC = "Restricted to superuser privileges or above. Deletes a film location by its internal ID.";
  static final String FILM_LOCATION_PATCH_SUMMARY = "Modifies a film location.";
  static final String FILM_LOCATION_PATCH_DESC = "Restricted to superuser privileges or above. Patches a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the image should be included in the body. Can be used to approve a location submission.";

  static final String IMAGE_LIST_SUMMARY = "Gets all images for a location.";
  static final String IMAGE_LIST_DESC = "Gets all of the images on a film location endpoint, ordered by the time of creation.";
  static final String IMAGE_ALL_SUMMARY = "Gets all images.";
  static final String IMAGE_ALL_DESC = "Gets all images, ordered by their time of creation.";
  static final String IMAGE_GET_SUMMARY = "Gets an image.";
  static final String IMAGE_GET_DESC = "Gets a single image on a film location endpoint, referenced by its internal ID";
  static final String IMAGE_POST_SUMMARY = "Posts a new image.";
  static final String IMAGE_POST_DESC = "Posts a new image to a film location endpoint. Should contain a Google ID, Google name, and profile picture URL for the submitter and the URL the image is located at.";
  static final String IMAGE_POST_BAD_DESC = "Posts an image. Posting should not be done directly, it should be done on a specific FilmLocation endpoint.";
  static final String IMAGE_DELETE_SUMMARY = "Deletes an image.";
  static final String IMAGE_DELETE_DESC = "Restricted to superuser privileges or above. Deletes a single image on a film location endpoint, referenced by its internal ID.";
  static final String IMAGE_PATCH_SUMMARY = "Modifies an image.";
  static final String IMAGE_PATCH_DESC = "Restricted to superuser privileges or above. Patches an image from the images endpoint on a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the image should be included in the body. Can be used to approve an image submission.";

  static final String USER_COMMENT_LIST_SUMMARY = "Gets all user comments for a location.";
  static final String USER_COMMENT_LIST_DESC = "Gets all of the user comments on a film location endpoint, ordered by the time of creation.";
  static final String USER_COMMENT_ALL_SUMMARY = "Gets all user comments.";
  static final String USER_COMMENT_ALL_DESC = "Gets all user comments, ordered by their time of creation.";
  static final String USER_COMMENT_GET_SUMMARY = "Gets a user comment.";
  static final String USER_COMMENT_GET_DESC = "Gets a single user comment, referenced by its internal ID";
  static final String USER_COMMENT_POST_SUMMARY = "Posts a new user comment.";
  static final String USER_COMMENT_POST_DESC = "Posts a new user comment to a film location endpoint. Should contain a Google ID, Google name, and profile picture URL for the author and the text content of the comment.";
  static final String USER_COMMENT_POST_BAD_DESC = "Posts a new user comment. Posting should not be done directly, it should be done on a specific FilmLocation endpoint.";
  static final String USER_COMMENT_DELETE_SUMMARY = "Deletes a user comment.";
  static final String USER_COMMENT_DELETE_DESC = "Restricted to superuser privileges or above. Deletes a single user comment on a film location endpoint, referenced by its internal ID.";
  static final String USER_COMMENT_PATCH_SUMMARY = "Modifies a user comment.";
  static final String USER_COMMENT_PATCH_DESC = "Restricted to superuser privileges or above. Patches a user comment from the user comments endpoint on a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the user comment should be included in the body. Can be used to approve a comment submission. ";

  static final String USER_LIST_SUMMARY = "Gets all users.";
  static final String USER_LIST_DESC = "Admin access only. Gets all users, ordered alphabetically by the name on their account.";
  static final String USER_GET_SUMMARY = "Gets a single user.";
  static final String USER_GET_DESC = "Admin access only. Gets a user from the users endpoint, referenced by their internal ID.";
  static final String USER_POST_SUMMARY = "Posts a new user.";
  static final String USER_POST_DESC = "Admin access only. Posts a new user to the users endpoint. Should include a Google ID, full name, and gmail address.";
  static final String USER_DELETE_SUMMARY = "Deletes a user.";
  static final String USER_DELETE_DESC = "Admin access only. Deletes a user from the users endpoint, referenced by their internal ID.";
  static final String USER_PATCH_SUMMARY = "Modifies a user.";
  static final String USER_PATCH_DESC = "Admin access only. Patches a user from the users endpoint. All data will be overwritten - current fields to stay the same must be included as well. Can be used to ban or unban a user.";
  static final String USER_LIST_COMMENTS_SUMMARY = "Gets all comments submitted by a user.";
  static final String USER_LIST_COMMENTS_DESC = "Admin access only. Shows all of the comments submitted by a user in descending order by timestamp. Can be used to monitor activity.";
  static final String USER_LIST_LOCATIONS_SUMMARY = "Gets all locations submitted by a user.";
  static final String USER_LIST_LOCATIONS_DESC = "Admin access only. Shows all of the locations submitted by a user in descending order by timestamp. Can be used to monitor activity.";
  static final String USER_LIST_IMAGES_SUMMARY = "Gets all images submitted by a user.";
  static final String USER_LIST_IMAGES_DESC = "Admin access only. Shows all of the locations submitted by a user in descending order by timestamp. Can be used to monitor activity.";
  static final String USER_PURGE_SUMMARY = "Deletes all submitted content from this user.";
  static final String USER_PURGE_DESC = "Admin access only. Deletes all locations, comments, and images submitted by a user. Efficient way to eliminate the contributions of a malicious user.";

  static final String PRODUCTION_LIST_SUMMARY = "Gets all productions/";
  static final String PRODUCTION_LIST_DESC = "Gets all of the productions on the productions endpoint, ordered alphabetically by their title.";
  static final String PRODUCTION_GET_SUMMARY = "Gets a single production.";
  static final String PRODUCTION_GET_DESC = "Gets a single production from the productions endpoint, referenced by its internal ID.";
  static final String PRODUCTION_POST_SUMMARY = "Posts a new production.";
  static final String PRODUCTION_POST_DESC = "Restricted to superuser privileges or above. Posts a new production. Should have an IMDb ID, plot summary, and title at least.";
  static final String PRODUCTION_DELETE_SUMMARY = "Deletes a production.";
  static final String PRODUCTION_DELETE_DESC = "Restricted to superuser privileges or above. Deletes a production from the productions endpoint, referenced by its internal ID.";
  static final String PRODUCTION_PATCH_SUMMARY = "Modifies a production.";
  static final String PRODUCTION_PATCH_DESC = "Restricted to superuser privileges or above. Patches a production from the productions endpoint. All data will be overwritten - current fields to stay the same must be included as well. The ID should be included in the body.";
  static final String PRODUCTION_POSTER_SUMMARY = "Retrieves a poster image for the production.";
  static final String PRODUCTION_POSTER_DESC = "Retrieves a poster image relayed its source on the OMDb API. Image is returned as a raw StreamingBodyResponse to be deserialized.";

  static final String RESPONSE_SUCCESSFUL = "Operation successful.";
  static final String RESPONSE_400 = "Failure to parse request. Double check any IDs.";
  static final String RESPONSE_401 = "Failure to authorize. Advised to check authorization token header.";
  static final String RESPONSE_403_USER = "Forbidden to access. The user attempting to access this endpoint may be banned from the service.";
  static final String RESPONSE_403_SUPER = "Forbidden to access. This endpoint requires superuser privileges or higher.";
  static final String RESPONSE_403_ADMIN = "Forbidden to access. This endpoint is restricted to the administrator only.";
  static final String RESPONSE_404 = "Unrecognized request. Double check URL.";
  static final String RESPONSE_404_POSTER = "Not found. Possible problem in reaching the OMDb API, or no poster for the production may be available.";
  static final String RESPONSE_500 = "Internal server error. This is frequently caused by a runtime error or an unexpected exception.";

}