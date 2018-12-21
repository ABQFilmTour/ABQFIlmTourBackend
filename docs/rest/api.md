# Swagger documentation for the Project Odeon backend

## HTTPS://jscpeterson.com/rest/

Documentation for the Project Odeon backend



**Version** v2














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
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets a list of film locations</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a film location.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch">Patches a single film location</a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets a single film location</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes a film location</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/images</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getImages">Gets all images on a FilmLocation.</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts an image to a film location.</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/images/</strong></th>
      </tr>
      
        
        
        
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch">Patches an image. All data will be overwritten.</a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/images/{imageId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getImage">Gets all images on a FilmLocation.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteImage">Deletes an image on a film location.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/user_comments</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getUserComments">Gets all user comments on a location.</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a user comment to a location.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch">Patches a UserComment on a location. All data to stay the same must be included.</a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/film_locations/{filmLocationId}/user_comments/{userCommentId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#getUserComment">Gets a single UserComment from a location.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#deleteUserComment">Deletes a UserComment from a location.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/images</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Orders Images</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Post Image</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/images/{imageId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets an image</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes an image</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/productions</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list"></a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post"></a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch"></a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/productions/{productionId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get"></a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete"></a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/user_comments</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all user comments.</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a user comment.</a></td></tr>
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/user_comments/{userCommentId}</strong></th>
      </tr>
      
        
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes a user comment.</a></td></tr>
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/user_comments/{user_comments}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets a single comment.</a></td></tr>
        
        
        
        
        
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/users</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#list">Gets all users</a></td></tr>
        
        <tr><td>&nbsp;</td><td><code>POST</code></td><td><a href="#post">Posts a google user.</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>PATCH</code></td><td><a href="#patch">Patches a google user</a></td></tr>
        
      
    
      <tr>
        <th colspan="3" style="text-align: left;"><strong>/users/{userId}</strong></th>
      </tr>
      
        <tr><td>&nbsp;</td><td><code>GET</code></td><td><a href="#get">Gets google user</a></td></tr>
        
        
        <tr><td>&nbsp;</td><td><code>DELETE</code></td><td><a href="#delete">Deletes google user</a></td></tr>
        
        
        
      
    
  </tbody>
</table>


## /film_locations



### <a name="list"></a>GET

Gets a list of film locations

Gets a list of film locations.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/FilmLocation">FilmLocation</a>]|






### <a name="post"></a>POST

Posts a film location.









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
| 200    | successful operation | <a href="#/definitions/FilmLocation">FilmLocation</a>|








### <a name="patch"></a>PATCH

Patches a single film location

Patches a film location. All data will be overwritten - current fields to stay the same must be included as well.







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
| default    | successful operation |  - |



<a name=""></a>



## /film_locations/{filmLocationId}



### <a name="get"></a>GET

Gets a single film location

Gets a single film location.







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
| 200    | successful operation | <a href="#/definitions/FilmLocation">FilmLocation</a>|








### <a name="delete"></a>DELETE

Deletes a film location

Deletes a film location







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
| 204    |  |  - |







<a name=""></a>



## /film_locations/{filmLocationId}/images



### <a name="getImages"></a>GET

Gets all images on a FilmLocation.









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
| 200    | successful operation | Array[<a href="#/definitions/Image">Image</a>]|






### <a name="post"></a>POST

Posts an image to a film location.









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
| 200    | successful operation | <a href="#/definitions/Image">Image</a>|









<a name=""></a>



## /film_locations/{filmLocationId}/images/













### <a name="patch"></a>PATCH

Patches an image. All data will be overwritten.









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
| default    | successful operation |  - |



<a name=""></a>



## /film_locations/{filmLocationId}/images/{imageId}



### <a name="getImage"></a>GET

Gets all images on a FilmLocation.









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
| 200    | successful operation | <a href="#/definitions/Image">Image</a>|








### <a name="deleteImage"></a>DELETE

Deletes an image on a film location.









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
| 204    |  |  - |







<a name=""></a>



## /film_locations/{filmLocationId}/user_comments



### <a name="getUserComments"></a>GET

Gets all user comments on a location.









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
| 200    | successful operation | Array[<a href="#/definitions/UserComment">UserComment</a>]|






### <a name="post"></a>POST

Posts a user comment to a location.









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
| 200    | successful operation | <a href="#/definitions/UserComment">UserComment</a>|








### <a name="patch"></a>PATCH

Patches a UserComment on a location. All data to stay the same must be included.









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
| default    | successful operation |  - |



<a name=""></a>



## /film_locations/{filmLocationId}/user_comments/{userCommentId}



### <a name="getUserComment"></a>GET

Gets a single UserComment from a location.









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
| 200    | successful operation | <a href="#/definitions/UserComment">UserComment</a>|








### <a name="deleteUserComment"></a>DELETE

Deletes a UserComment from a location.









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
| 204    |  |  - |







<a name=""></a>



## /images



### <a name="list"></a>GET

Orders Images

Orders by Id ascending.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Image">Image</a>]|






### <a name="post"></a>POST

Post Image

Saves image to image repository







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
| 200    | successful operation | <a href="#/definitions/Image">Image</a>|









<a name=""></a>



## /images/{imageId}



### <a name="get"></a>GET

Gets an image

Finds image by the image UUID







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
| 200    | successful operation | <a href="#/definitions/Image">Image</a>|








### <a name="delete"></a>DELETE

Deletes an image

Enables you to delete an image from database







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
| 204    |  |  - |







<a name=""></a>



## /productions



### <a name="list"></a>GET











#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/Production">Production</a>]|






### <a name="post"></a>POST











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
| 200    | successful operation | <a href="#/definitions/Production">Production</a>|








### <a name="patch"></a>PATCH











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
| default    | successful operation |  - |



<a name=""></a>



## /productions/{productionId}



### <a name="get"></a>GET











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
| 200    | successful operation | <a href="#/definitions/Production">Production</a>|








### <a name="delete"></a>DELETE











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
| 204    |  |  - |







<a name=""></a>



## /user_comments



### <a name="list"></a>GET

Gets all user comments.









#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/UserComment">UserComment</a>]|






### <a name="post"></a>POST

Posts a user comment.









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
| 200    | successful operation | <a href="#/definitions/UserComment">UserComment</a>|









<a name=""></a>



## /user_comments/{userCommentId}









### <a name="delete"></a>DELETE

Deletes a user comment.









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
| 204    |  |  - |







<a name=""></a>



## /user_comments/{user_comments}



### <a name="get"></a>GET

Gets a single comment.









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
| 200    | successful operation | <a href="#/definitions/UserComment">UserComment</a>|













<a name=""></a>



## /users



### <a name="list"></a>GET

Gets all users

Retrieves all users with their ID in an list.







#### Request









#### Response

**Content-Type:** application/json


| Status Code | Reason      | Response Model |
|-------------|-------------|----------------|
| 200    | successful operation | Array[<a href="#/definitions/GoogleUser">GoogleUser</a>]|






### <a name="post"></a>POST

Posts a google user.

Posts a googel user.







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

Patches a google user

Patches a user. This will overwrite everything. if just changing one field all other current fields must be included.







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

Gets google user

Gets google user id and returns google user.







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

Deletes google user

Takes user id as a parameter and deletes google user.







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
            <td><strong>userId</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>user</strong></td>
            <td>
                
                    <a href="#/definitions/GoogleUser">GoogleUser</a>
                    
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>created</strong></td>
            <td>
                
                    
                    string (date-time)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>id</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>longCoordinate</strong></td>
            <td>
                
                    
                    number (double)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>latCoordinate</strong></td>
            <td>
                
                    
                    number (double)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>siteName</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
            <td>-</td>
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
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>production</strong></td>
            <td>
                
                    <a href="#/definitions/Production">Production</a>
                    
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
            <td>-</td>
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
            <td>-</td>
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
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>approved</strong></td>
            <td>
                
                    
                    boolean
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
              optional
            </td>
            <td>-</td>
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
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>googleName</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>gmailAddress</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
            <td>-</td>
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
            <td>-</td>
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
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>created</strong></td>
            <td>
                
                    
                    string (date-time)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
            <td>-</td>
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
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>userId</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>user</strong></td>
            <td>
                
                    <a href="#/definitions/GoogleUser">GoogleUser</a>
                    
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>approved</strong></td>
            <td>
                
                    
                    boolean
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
              optional
            </td>
            <td>-</td>
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
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>title</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>type</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
            <td>-</td>
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
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>posterUrl</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>created</strong></td>
            <td>
                
                    
                    string (date-time)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
            <td><strong>text</strong></td>
            <td>
                
                    
                    string
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>userId</strong></td>
            <td>
                
                    
                    string (uuid)
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>user</strong></td>
            <td>
                
                    <a href="#/definitions/GoogleUser">GoogleUser</a>
                    
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
            <!--<td></td>-->
        </tr>
    
        <tr>
            <td><strong>approved</strong></td>
            <td>
                
                    
                    boolean
                
            </td>
            <td>
              optional
            </td>
            <td>-</td>
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
