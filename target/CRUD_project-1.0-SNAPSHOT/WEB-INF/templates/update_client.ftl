<html>
<head>
    <title>Update client</title>
</head>
<body>
<form action="/update" method="POST">
    <p><input name="phone" type="text" placeholder="${client.phone}"></p>
    <p><input name="name" type="text" placeholder="${client.name}"></p>
    <p><input name="surname" type="text" placeholder="${client.surname}"></p>
    <p><input name="city" type="text" placeholder="${client.city}"></p>
    <p><input name="id" type="hidden" value="${client.ID}"></p>
    <!-- TODO: status -->
    <p><select size="3" multiple name="status">
        <option disabled>Select status</option>
        <option value="1">new client</option>
        <option selected value="2">interested</option>
        <option value="3">order is processed</option>
        <option value="4">order completed</option>
        <option value="5">order cancelled</option>
    </select></p>
    <p><input type="submit"  value="Update"></p>
</form>
</body>
</html>