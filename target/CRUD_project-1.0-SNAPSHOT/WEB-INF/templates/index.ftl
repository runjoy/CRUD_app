<!DOCTYPE html>
<html>
<head>
    <title>CRUD app</title>
    <link href="/css/style.css" rel="stylesheet">
    <script src="/js/script.js"></script>
</head>
<body>

<#if clients?has_content>
<table>
    <tr>
        <td>Phone</td>
        <td>Surname</td>
        <td>Name</td>
        <td>City</td>
        <td>Status</td>
        <td>Update</td>
        <td>Remove</td>
    </tr>

    <#list clients as client>
        <tr>
            <td>${client.phone}</td>
            <td>${client.surname}</td>
            <td>${client.name}</td>
            <td>${client.city}</td>
            <td id="td${client.status}">${client.getStatusText()}</td>
            <td>
                <form action="/update" method="GET">
                    <input type="hidden" name="id" value="${client.ID}"/>
                    <button type="submit">Update</button>
                </form>
            </td>
            <td>
                <form action="/delete" method="GET">
                    <input type="hidden" name="id" value="${client.ID}"/>
                    <button type="submit">Remove</button>
                </form>
            </td>
        </tr>
    </#list>
    <tr>
        <td colspan="7"><a href="#" onclick='changeVisibleDiv()' style="display: block;">add new client</a></td>
    </tr>
    <tr id="add_client" style="display: none">
        <form action="/add" method="POST">
            <td><label>Phone number: <input name="phone" type="text" placeholder="phone number"></label></td>
            <td><label>Surname: <input name="surname" type="text" placeholder="surname"></label></td>
            <td><label>Name: <input name="name" type="text" placeholder="name"></label></td>
            <td><label>City: <input name="city" type="text" placeholder="city"></label></td>
            <td><label>Select status:</label>
                <select size="1" name="status">
                    <option selected value="1">new client</option>
                    <option value="2">interested</option>
                    <option value="3">order is processed</option>
                    <option value="4">order completed</option>
                    <option value="5">order cancelled</option>
                </select>
            </td>
            <td colspan="2"><input type="submit" value="Add"></td>
        </form>
    </tr>
</table>
<#else>
<p>No users yet</p>
</#if>
<!--form action="/add" method="GET">
    <button type="submit">Add</button>
</form-->
</body>
</html>