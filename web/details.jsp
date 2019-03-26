<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 21/03/2019
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item details</title>
    <style>

        body {
            margin: 10px;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 50%;
            margin-bottom: 5px;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        .go-to-button {
            padding: 5px;
        }

    </style>
</head>
<body style="font-family: sans-serif; font-size: 13px;">

<table class="details-layout">
    <tr>
        <th>
            Barcode
        </th>
        <th>
            Name
        </th>
        <th>
            Quantity
        </th>
        <th>
            Price ($)
        </th>
    </tr>

    <tr>
        <td>
            ${param.get("barcode")}
        </td>
        <td>
            ${param.get("name")}
        </td>
        <td>
            ${param.get("quantity")}
        </td>
        <td>
            ${param.get("price")}
        </td>
    </tr>

</table>

<div>

    <form action="/">
        <input type="submit" value="Return to main page" class="go-to-button">
    </form>

</div>

</body>
</html>