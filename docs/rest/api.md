# ABQ Film Tour Backend

## HTTPS://jscpeterson.com/rest/

Documentation for the RESTful API for ABQ Film Tour



**Version** 0.1.1














# APIs


<table>
  <thead>
    <tr>
      <th>Path</th>
      <th>Method</th>
      <th>Summary</th>
    </tr>
  </thead>
  <tbody>
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all film locations. </a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a new film location.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch">Modifies a film location.</a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets a film location.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes a film location.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/images</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getImages">Gets all images for a location.</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a new image.</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/images/</strong></th>
      </tr>
      
        
        
        
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch">Modifies an image.</a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/images/{imageId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getImage">Gets an image.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteImage">Deletes an image.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/user_comments</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getUserComments">Gets all user comments for a location.</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a new user comment.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch">Modifies a user comment.</a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/user_comments/{userCommentId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getUserComment">Gets a user comment.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteUserComment">Deletes a user comment.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/images</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all images.</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a new image.</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/images/{imageId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets an image.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes an image.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/productions</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all productions/</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a new production.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch">Modifies a production.</a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/productions/{productionId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets a single production.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes a production.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/productions/{productionId}/poster</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getPoster">Retrieves a poster image for the production.</a></td></tr>
        
        
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/user_comments</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all user comments.</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a new user comment.</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/user_comments/{userCommentId}</strong></th>
      </tr>
      
        
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Modifies a user comment.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/user_comments/{user_comments}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Deletes a user comment.</a></td></tr>
        
        
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/users</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all users.</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a new user.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch">Modifies a user.</a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/users/{userId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets a single user.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes a user.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/users/{userId}/film_locations</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getFilmLocations">Gets all locations submitted by a user.</a></td></tr>
        
        
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/users/{userId}/images</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getImages">Gets all images submitted by a user.</a></td></tr>
        
        
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/users/{userId}/user_comments</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getUserComments">Gets all comments submitted by a user.</a></td></tr>
        
        
        
        
        
        
      
    
  </tbody>
</table>


## /film_locations



### <a name="list"></a>GET

Gets all film locations. 

Gets all film locations, ordered by the time of creation.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | Array[<a href="#/definitions/FilmLocation">FilmLocation</a>]|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |






### <a name="post"></a>POST

Posts a new film location.

Posts a new film location to the film locations endpoint. Should include coordinates, a site name, a Google ID, Google name, profile picture URL, and an associated Production at the minimum.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/FilmLocation">FilmLocation</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/FilmLocation">FilmLocation</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |








### <a name="patch"></a>PATCH

Modifies a film location.

Restricted to superuser privileges or above. Patches a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the image should be included in the body. Can be used to approve a location submission.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/FilmLocation">FilmLocation</a> 
    </td>

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |



<a name=""></a>



## /film_locations/{filmLocationId}



### <a name="get"></a>GET

Gets a film location.

Gets a single film location by its internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/FilmLocation">FilmLocation</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |








### <a name="delete"></a>DELETE

Deletes a film location.

Restricted to superuser privileges or above. Deletes a film location by its internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |







<a name=""></a>



## /film_locations/{filmLocationId}/images



### <a name="getImages"></a>GET

Gets all images for a location.

Gets all of the images on a film location endpoint, ordered by the time of creation.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | Array[<a href="#/definitions/Image">Image</a>]|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |






### <a name="post"></a>POST

Posts a new image.

Posts a new image to a film location endpoint. Should contain a Google ID, Google name, and profile picture URL for the submitter and the URL the image is located at.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/Image">Image</a> 
    </td>

</tr>

<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/Image">Image</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |









<a name=""></a>



## /film_locations/{filmLocationId}/images/













### <a name="patch"></a>PATCH

Modifies an image.

Restricted to superuser privileges or above. Patches an image from the images endpoint on a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the image should be included in the body. Can be used to approve an image submission.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>

<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/Image">Image</a> 
    </td>

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |



<a name=""></a>



## /film_locations/{filmLocationId}/images/{imageId}



### <a name="getImage"></a>GET

Gets an image.

Gets a single image on a film location endpoint, referenced by its internal ID







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>

<tr>
    <td><strong>imageId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/Image">Image</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |








### <a name="deleteImage"></a>DELETE

Deletes an image.

Restricted to superuser privileges or above. Deletes a single image on a film location endpoint, referenced by its internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>

<tr>
    <td><strong>imageId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |







<a name=""></a>



## /film_locations/{filmLocationId}/user_comments



### <a name="getUserComments"></a>GET

Gets all user comments for a location.

Gets all of the user comments on a film location endpoint, ordered by the time of creation.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | Array[<a href="#/definitions/UserComment">UserComment</a>]|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |






### <a name="post"></a>POST

Posts a new user comment.

Posts a new user comment to a film location endpoint. Should contain a Google ID, Google name, and profile picture URL for the author and the text content of the comment.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/UserComment">UserComment</a> 
    </td>

</tr>

<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/UserComment">UserComment</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |








### <a name="patch"></a>PATCH

Modifies a user comment.

Restricted to superuser privileges or above. Patches a user comment from the user comments endpoint on a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the user comment should be included in the body. Can be used to approve a comment submission. 







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>

<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/UserComment">UserComment</a> 
    </td>

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |



<a name=""></a>



## /film_locations/{filmLocationId}/user_comments/{userCommentId}



### <a name="getUserComment"></a>GET

Gets a user comment.

Gets a single user comment, referenced by its internal ID







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>

<tr>
    <td><strong>userCommentId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/UserComment">UserComment</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |








### <a name="deleteUserComment"></a>DELETE

Deletes a user comment.

Restricted to superuser privileges or above. Deletes a single user comment on a film location endpoint, referenced by its internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>filmLocationId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>

<tr>
    <td><strong>userCommentId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |







<a name=""></a>



## /images



### <a name="list"></a>GET

Gets all images.

Gets all images, ordered by their time of creation.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | Array[<a href="#/definitions/Image">Image</a>]|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |






### <a name="post"></a>POST

Posts a new image.

Posts an image. Posting should not be done directly, it should be done on a specific FilmLocation endpoint.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/Image">Image</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/Image">Image</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |









<a name=""></a>



## /images/{imageId}



### <a name="get"></a>GET

Gets an image.

Gets a single image on a film location endpoint, referenced by its internal ID







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>imageId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/Image">Image</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |








### <a name="delete"></a>DELETE

Deletes an image.

Restricted to superuser privileges or above. Deletes a single image on a film location endpoint, referenced by its internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>imageId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |







<a name=""></a>



## /productions



### <a name="list"></a>GET

Gets all productions/

Gets all of the productions on the productions endpoint, ordered alphabetically by their title.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | Array[<a href="#/definitions/Production">Production</a>]|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |






### <a name="post"></a>POST

Posts a new production.

Restricted to superuser privileges or above. Posts a new production. Should have an IMDb ID, plot summary, and title at least.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/Production">Production</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/Production">Production</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |








### <a name="patch"></a>PATCH

Modifies a production.

Restricted to superuser privileges or above. Patches a production from the productions endpoint. All data will be overwritten - current fields to stay the same must be included as well. The ID should be included in the body.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/Production">Production</a> 
    </td>

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |



<a name=""></a>



## /productions/{productionId}



### <a name="get"></a>GET

Gets a single production.

Gets a single production from the productions endpoint, referenced by its internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>productionId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/Production">Production</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |








### <a name="delete"></a>DELETE

Deletes a production.

Restricted to superuser privileges or above. Deletes a production from the productions endpoint, referenced by its internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>productionId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |







<a name=""></a>



## /productions/{productionId}/poster



### <a name="getPoster"></a>GET

Retrieves a poster image for the production.

Retrieves a poster image relayed its source on the OMDb API. Image is returned as a raw StreamingBodyResponse to be deserialized.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>productionId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** image/gif, image/jpeg, image/png, video/webm, video/mp4, application/octet-stream


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/StreamingResponseBody">StreamingResponseBody</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |
| 404    | Not found. Possible problem in reaching the OMDb API, or no poster for the production may be available. |  - |













<a name=""></a>



## /user_comments



### <a name="list"></a>GET

Gets all user comments.

Gets all user comments, ordered by their time of creation.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | Array[<a href="#/definitions/UserComment">UserComment</a>]|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |






### <a name="post"></a>POST

Posts a new user comment.

Posts a new user comment. Posting should not be done directly, it should be done on a specific FilmLocation endpoint.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/UserComment">UserComment</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/UserComment">UserComment</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |









<a name=""></a>



## /user_comments/{userCommentId}









### <a name="delete"></a>DELETE

Modifies a user comment.

Restricted to superuser privileges or above. Patches a user comment from the user comments endpoint on a film location. All data will be overwritten - current fields to stay the same must be included as well. The ID of the user comment should be included in the body. Can be used to approve a comment submission. 







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>userCommentId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    | Operation successful. |  - |
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint requires superuser privileges or higher. |  - |







<a name=""></a>



## /user_comments/{user_comments}



### <a name="get"></a>GET

Deletes a user comment.

Restricted to superuser privileges or above. Deletes a single user comment on a film location endpoint, referenced by its internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>user_comments</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | <a href="#/definitions/UserComment">UserComment</a>|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. The user attempting to access this endpoint may be banned from the service. |  - |













<a name=""></a>



## /users



### <a name="list"></a>GET

Gets all users.

Admin access only. Gets all users, ordered alphabetically by the name on their account.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | Operation successful. | Array[<a href="#/definitions/GoogleUser">GoogleUser</a>]|
| 401    | Failure to authorize. Advised to check authorization token header. |  - |
| 403    | Forbidden to access. This endpoint is restricted to the administrator only. |  - |






### <a name="post"></a>POST

Posts a new user.

Admin access only. Posts a new user to the users endpoint. Should include a Google ID, full name, and gmail address.







#### Request


**Content-Type:** application/json



##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/GoogleUser">GoogleUser</a> 
    </td>

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/GoogleUser">GoogleUser</a>|








### <a name="patch"></a>PATCH

Modifies a user.

Admin access only. Patches a user from the users endpoint. All data will be overwritten - current fields to stay the same must be included as well. Can be used to ban or unban a user.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>body</strong></td>
    <td>body</td>
    <td>no</td>
    <td></td>
    <td></td>

    <td>
    
    <a href="#/definitions/GoogleUser">GoogleUser</a> 
    </td>

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| default    | successful operation |  - |



<a name=""></a>



## /users/{userId}



### <a name="get"></a>GET

Gets a single user.

Admin access only. Gets a user from the users endpoint, referenced by their internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>userId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | <a href="#/definitions/GoogleUser">GoogleUser</a>|








### <a name="delete"></a>DELETE

Deletes a user.

Admin access only. Deletes a user from the users endpoint, referenced by their internal ID.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>userId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response




| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 204    |  |  - |







<a name=""></a>



## /users/{userId}/film_locations



### <a name="getFilmLocations"></a>GET

Gets all locations submitted by a user.

Admin access only. Shows all of the locations submitted by a user in descending order by timestamp. Can be used to monitor activity.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>userId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/FilmLocation">FilmLocation</a>]|













<a name=""></a>



## /users/{userId}/images



### <a name="getImages"></a>GET

Gets all images submitted by a user.

Admin access only. Shows all of the locations submitted by a user in descending order by timestamp. Can be used to monitor activity.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>userId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Image">Image</a>]|













<a name=""></a>



## /users/{userId}/user_comments



### <a name="getUserComments"></a>GET

Gets all comments submitted by a user.

Admin access only. Shows all of the comments submitted by a user in descending order by timestamp. Can be used to monitor activity.







#### Request





##### Parameters

<table border="1">
    <colgroup>
      <col span="3" width="15%">
      <col width="25%">
      <col span="2" width="15%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Located in</th>
        <th>Required</th>
        <th>Description</th>
        <th>Default</th>
        <th>Schema</th>
    </tr>



<tr>
    <td><strong>userId</strong></td>
    <td>path</td>
    <td>yes</td>
    <td></td>
    <td></td>

    
            <td>string (uuid)</td>
    

</tr>


</table>



#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/UserComment">UserComment</a>]|













<a name=""></a>




# Definitions

## <a name="/definitions/FilmLocation">FilmLocation</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
        <tr>
            <td><strong>id</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              read-only
            </td>
            <td>Internal ID for this location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>longCoordinate</strong></td>
            <td>
                
                    
                    number (double)
                
            </td>
            <td>
              required
            </td>
            <td>The longitude coordinate of the location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>latCoordinate</strong></td>
            <td>
                
                    
                    number (double)
                
            </td>
            <td>
              required
            </td>
            <td>The latitude coordinate of the location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>siteName</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              required
            </td>
            <td>The name of the site.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>imdbId</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The IMDb ID for this location. Included in city data entries.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>productionId</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The transient ID of the production, used to reference during a post.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>production</strong></td>
            <td>
                
                    <a href="#/definitions/Production">Production</a>
                    
                
            </td>
            <td>
              read-only
            </td>
            <td>The production (film or television series) associated with this location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>address</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The address for this location. Included in city data entries.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>shootDate</strong></td>
            <td>
                
                    
                    integer (int64)
                
            </td>
            <td>
              optional
            </td>
            <td>The time of the last shoot in epoch date format. Included in city data entries.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>originalDetails</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>General information about the last shoot. Included in city data entries</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>approved</strong></td>
            <td>
                
                    
                    boolean
                
            </td>
            <td>
              required
            </td>
            <td>The approval status of the location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>googleId</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>Google ID of the user</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>userName</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The full name of the Google user who submitted this content</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>userPictureUrl</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The URL of the Google user's profile image.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>href</strong></td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
</table>

## <a name="/definitions/GoogleUser">GoogleUser</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
        <tr>
            <td><strong>id</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              read-only
            </td>
            <td>Internal ID for this location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>googleId</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>Transient Google ID of the user, used to reference the user during a post.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>googleName</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              read-only
            </td>
            <td>The full name on the user's Google Account</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>gmailAddress</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              read-only
            </td>
            <td>The email address on the Google account.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>banned</strong></td>
            <td>
                
                    
                    boolean
                
            </td>
            <td>
              optional
            </td>
            <td>The banned status of the user</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>banReason</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The reason for a ban.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>userRole</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The user's privilege role in the database, primarily for internal records.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>pictureUrl</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The URL to the user's profile image.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>href</strong></td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
</table>

## <a name="/definitions/Image">Image</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
        <tr>
            <td><strong>id</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              read-only
            </td>
            <td>Internal ID for this location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>filmLocation</strong></td>
            <td>
                
                    <a href="#/definitions/FilmLocation">FilmLocation</a>
                    
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>description</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>An optional description of the image's contents.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>url</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The URL the image is located at.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>googleId</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>Google ID of the user</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>userName</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The full name of the Google user who submitted this content</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>userPictureUrl</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The URL of the Google user's profile image.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>approved</strong></td>
            <td>
                
                    
                    boolean
                
            </td>
            <td>
              required
            </td>
            <td>The approval status of the location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>href</strong></td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
</table>

## <a name="/definitions/Production">Production</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
        <tr>
            <td><strong>id</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              read-only
            </td>
            <td>Internal ID for this location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>imdbId</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              required
            </td>
            <td>ID of this production associated with its entry in the IMDb.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>title</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              required
            </td>
            <td>Title of the production.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>type</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              required
            </td>
            <td>Type of "movie" or "series"</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>releaseYear</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>Release year, can cover a range such as "2008-2010".</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>plot</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>Plot summary of the production, 300 char max.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>href</strong></td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
</table>

## <a name="/definitions/StreamingResponseBody">StreamingResponseBody</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
</table>

## <a name="/definitions/UserComment">UserComment</a>

<table border="1" style="width: 100%">
    <colgroup>
      <col span="2" width="20%">
      <col width="25%">
      <col width="35%">
    </colgroup>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Mode</th>
        <th>Description</th>
        <!--<th>Example</th>-->
    </tr>
    
        <tr>
            <td><strong>id</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              read-only
            </td>
            <td>Internal ID for this location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>filmLocation</strong></td>
            <td>
                
                    <a href="#/definitions/FilmLocation">FilmLocation</a>
                    
                
            </td>
            <td>
              read-only
            </td>
            <td>The Film Location associated with this entity.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>text</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The text content of this comment. 4096 character max</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>googleId</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>Google ID of the user</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>userName</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The full name of the Google user who submitted this content</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>userPictureUrl</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>The URL of the Google user's profile image.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>approved</strong></td>
            <td>
                
                    
                    boolean
                
            </td>
            <td>
              required
            </td>
            <td>The approval status of the location.</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>href</strong></td>
            <td>
                
                    
                    string (uri)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
</table>
