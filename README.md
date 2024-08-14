# Boggle Game

A Java-based Boggle game featuring a user-friendly graphical interface built using JavaFX. The game allows users to form words from a grid of letters, with real-time score tracking and word validation against a comprehensive dictionary.

## Features

- **Dynamic Board Generation:** Generates a 4x4 Boggle board with random letter placement.
- **User-Friendly Interface:** Smooth gameplay experience with an intuitive GUI.
- **Real-Time Word Validation:** Validates words against a dictionary of thousands of entries from `BoggleWords.txt`.
- **Score Tracking:** Automatically calculates and displays the score based on word length and correctness.
- **Responsive Design:** Ensures optimal gameplay across various screen sizes.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- JavaFX SDK (if not included with your JDK)

### Installation
 **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/BoggleGame.git
   cd BoggleGame
```

 **Compile and run the game::**
  ```bash
  javac Main.java
  java Main
  ```

## Gameplay

- The game presents a 4x4 grid of letters.
- Form words by connecting adjacent letters (horizontally, vertically, or diagonally).
- Type your words into the input field and hit "Submit."
- Valid words will be scored based on their length.
- The game will keep track of your score as you play.


## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your enhancements or bug fixes.

## Acknowledgements

The word list used for validation is sourced from the `BoggleWords.txt` file, containing thousands of valid words.



