# Ministore

## Introduction
A mini e-commerce android application using Jetpack Compose

## Getting Started

This project uses Jetpack Compose for UI designs. Ministore uses a Single-Activity Architecture with MVVM pattern. Jetpack Navigation library provide navigation through the application. Hilt is used for injecting dependencies where necessary. <br>
The `HomeScreen` gets a list of `ProductItem`, which are grouped into `ProductCategory` provided through a `CategoryRepository` with a `HomeViewModel`. The `CategoryRepository` takes care of retreiving all the products, a single product and a single category.<br>
`CartViewModel` handles cart management operations.

## Screenshots
<table>
  <tr>
    <td>
      <img src="login.png" />
    </td>
    <td>
      <img src="signup.png" />
    </td>
    <td>
      <img src="home.png" />
    </td>
    <td>
      <img src="details.png" />
    </td>
    <td>
      <img src="categories.png" />
    </td>
    <td>
      <img src="cart.png" />
    </td>
    <td>
      <img src="card.png" />
    </td>
  </tr>
</table>

## Project Setup
1. Clone project <br>
2. Import into Android Studio <br>
3. Download project dependencies <br>
4. Run the application



