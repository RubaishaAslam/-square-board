# -square-board
In this assignment we will consider a game played on a square board by two players. The board is
divided into a grid of size R × R where players take turns placing tiles. The game is won by the
player who is able to place k of their tiles in adjacent positions within the same row, column, or
diagonal of the grid. However, there are several unavailable squares in the grid where tiles cannot
be placed. If while playing the game there are no more empty squares in the grid to place tiles and
no player has won the game, then the game ends in a draw.
For this assignment you will be tasked with writing several Java classes needed for a program
to play the above game. The game will be played between a human player and the computer. The
values of R and k are parameters of the program. You will be provided part of the code for this
assignment, so you must follow the specifications below closely to ensure that your code will work
correctly with the code provided.
Figure ?? shows a possible set of tiles on a board of size 4 × 4 where k = 3; in this figure the
human player uses yellow tiles and the computer uses green tiles. Unavailable positions are dark
blue squares and empty positions are light blue squares. In Figure ??(a) the computer has placed
three green tiles in adjacent positions of the same diagonal, so it has won the game. In Figure ??(b)
the game has ended in a draw.
