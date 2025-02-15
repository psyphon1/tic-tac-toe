const board = document.getElementById("board");
const status = document.getElementById("status");
const resetButton = document.getElementById("reset");
let currentPlayer = "X";
let gameBoard = ["", "", "", "", "", "", "", "", ""];

board.addEventListener("click", (e) => {
    const index = e.target.dataset.index;
    if (gameBoard[index] === "" && index !== undefined) {
        gameBoard[index] = currentPlayer;
        e.target.textContent = currentPlayer;
        e.target.style.color = currentPlayer === "X" ? "#ff4757" : "#1e90ff";
        if (checkWin()) {
            status.textContent = `🎉 Player ${currentPlayer} Wins!`;
            board.style.pointerEvents = "none";
            return;
        }
        currentPlayer = currentPlayer === "X" ? "O" : "X";
        status.textContent = `Player ${currentPlayer}'s turn`;
    }
});

resetButton.addEventListener("click", () => {
    gameBoard.fill("");
    [...board.children].forEach(cell => cell.textContent = "");
    board.style.pointerEvents = "auto";
    currentPlayer = "X";
    status.textContent = "Player X's turn";
});

function checkWin() {
    const winPatterns = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8],
        [0, 3, 6], [1, 4, 7], [2, 5, 8],
        [0, 4, 8], [2, 4, 6]
    ];
    return winPatterns.some(pattern => 
        pattern.every(index => gameBoard[index] === currentPlayer)
    );
}
