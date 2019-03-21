<html>
<head>
    <title>Add client</title>
</head>
<body>
    <h1>Add client</h1>
    <form action="/add" method="POST">
        <p><label>Phone number: <input name="phone" type="text" placeholder="phone number"></label></p>
        <p><label>Name: <input name="name" type="text" placeholder="name"></label></p>
        <p><label>Surname: <input name="surname" type="text" placeholder="surname"></label></p>
        <p><label>City: <input name="city" type="text" placeholder="city"></label></p>
        <p><label>Select status:
            <select size="3" multiple name="status">
                <option selected value="1">new client</option>
                <option value="2">interested</option>
                <option value="3">order is processed</option>
                <option value="4">order completed</option>
                <option value="5">order cancelled</option>
            </select>
        </label></p>
        <p><input type="submit" value="Add"></p>
    </form>
</body>
</html>