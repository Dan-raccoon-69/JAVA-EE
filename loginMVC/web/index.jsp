<!DOCTYPE html>
<html>
   <head>
      <title>Login</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="styles.css"/>
   </head>
   <body>
      <form action="login" method="post" class="login-form">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" name="name" id="name">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" id="password">
        </div>

        <div class="form-group">
            <input type="submit" value="Enviar">
        </div>
    </form>
   </body>
</html>
