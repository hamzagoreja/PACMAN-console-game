##  Pacman Game (OOP-Based Java Project)

##  Project Overview

This project is a **console-based Pacman game** developed in **Java using Object-Oriented Programming (OOP)** concepts. The game simulates a simplified version of Pacman where the player controls Pacman to collect food while avoiding a ghost inside a maze-like board.

---

## Game Features

* Maze-based board using a 2D array
* Player-controlled Pacman (W/A/S/D movement)
* Randomly moving Ghost
* Food collection system with score tracking
* Lives system (3 lives)
* Collision detection (Pacman vs Ghost & Food)
* Boundary and wall restrictions

---

## Class Structure

### 1. **Pacman Class**

**Responsibility:** Represents the player.

#### Key Features:

* Stores position (`x`, `y`)
* Moves based on user input
* Prevents movement into walls

#### Concepts Used:

* **Encapsulation**

  ```java
  private int x;
  private int y;
  ```
* **Constructor**

  ```java
  public Pacman(int x,int y)
  ```
* **Method with Parameters**

  ```java
  move(char direction, gameboard board)
  ```
* **Validation Logic**

  * Uses `newX`, `newY` before updating position

---

### 2. **Ghost Class**

**Responsibility:** Enemy that moves randomly.

#### Key Features:

* Random movement using `Random` class
* Boundary checking

#### Concepts Used:

* **Random Class**

  ```java
  Random r = new Random();
  ```
* **Control Flow (switch-case)**
* **Encapsulation**

---

### 3. **Food Class**

**Responsibility:** Represents collectible food.

#### Key Features:

* Random respawn
* Ensures food does not spawn inside walls

#### Concepts Used:

* **Loop (do-while)**

  ```java
  do {
      x = r.nextInt(10);
      y = r.nextInt(10);
  } while(board.isWall(x, y));
  ```

### 4. **gameboard Class**

**Responsibility:** Displays the game environment.

#### Key Features:

* 2D grid (maze structure)
* Displays Pacman, Ghost, Food
* Checks walls

#### Concepts Used:

* **2D Arrays**

  ```java
  char[][] grid
  ```
* **Nested Loops**
* **Method Interaction**

  ```java
  display(Pacman p, Ghost g, Food f)
  ```
* **Boolean Method**

  ```java
  isWall(int x, int y)
  ```

---

### 5. **PACMANgame (Main Class)**

**Responsibility:** Controls the game flow.

#### Key Features:

* Game loop
* User input handling
* Score & lives tracking

#### Concepts Used:

* **Main Method**

  ```java
  public static void main(String[] args)
  ```
* **Game Loop**

  ```java
  while(lives > 0)
  ```
* **Object Creation**

  ```java
  Pacman pacman = new Pacman(1,1);
  ```
* **Scanner Class (Input Handling)**

  ```java
  Scanner sc = new Scanner(System.in);

  
  ```
## Architecture Design 
<img width="829" height="616" alt="image" src="https://github.com/user-attachments/assets/b8c56a7f-4729-4d3c-8354-2495f65a327d" />

## Game Flow

<img width="801" height="554" alt="image" src="https://github.com/user-attachments/assets/cfde5c5e-29bc-411c-8854-bc7027ef0c67" />
 
---

## Challenges Faced

* Handling movement within boundaries
* Preventing movement into walls
* Ensuring food spawns in valid positions
* Managing object interaction properly
* Fixing coordinate-based collision detection

---

## Possible Improvements

* Add multiple ghosts
* Add levels/difficulty
* Convert to GUI (Java Swing)
* Add sound effects
* Add timer or power-ups

---

##  Sample Output

```
# # # # # # # # # #
# P . . . . . . . #
# . # # . # # . . #
# . . # . . # . . #
# # . # # . # # . #
# . . . . . . # . #
# . # # # # . # . #
# . . . . # . . . #
# . # # . . . # G #
# # # # # # # # # #
```



## Conclusion

This project demonstrates how **Object-Oriented Programming concepts** can be applied to create a structured and interactive game. It highlights the importance of modular design, object interaction, 
and clean logic implementation.



## Author

** Hamza Goreja **


