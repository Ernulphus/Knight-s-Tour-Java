//Boaz Kaufman
//Knight's Tour 5x5
//


public Class Board()
{
Board(){
int board[12][12];
int open = 0;
int closed = -1;
int knight = 0;

//Initialize the empty board
void load_board(int board[12][12], int n)
{
  for(int i=0; i < n+4; ++i)
  {
    for(int j=0; j < n+4; ++j)
    {
      if ((i < 2 || j < 2))
      {
        board[i][j] = closed;
      }
      else if (i > n+1 || j > n+1)
      {
        board[i][j] = closed;
      }
      else
      {
        board[i][j] = open;
      }
    }
  }
}

//Print the board state to the terminal
void print_board(int board[12][12],int &counter, int n){
  System.out.print("[0;0H\n");
  for(int i=2; i < n+2; ++i)
  {
    for(int j=2; j < n+2; ++j)
    {
      if (board[i][j] < 10 && board[i][j] > -1)
        System.out.print( ' ' + board[i][j] + ' ');
      else
        System.out.print(board[i][j] + ' ');
    }
    System.out.println();
  }
  System.out.println("Move " + counter);
}

//
void move(int posx, int posy, int &counter, bool &done, int n)
{
  //usleep(1000);

  //If the board is completed (determined in the last move), return
  if (done)
  {
    return;
  }

  //Check that the space we're trying to move to is empty. If not, return.
  int current = board[posx][posy];
  if (current != 0)
  {
    return;
  }


    //Nothing wrong with the move, the knight jumps
    knight++;
    counter++;
    board[posx][posy] = knight;

    //print_board(board, counter);

    //check if the board is complete

    if (knight == n*n)
    {
      done = true;
      return;
    }
    if (done) {return;}
    /*
    done = true;
    for(int i=2; i < 10; ++i)
    {
      for(int j=2; j < 10; ++j)
      {
        if (board[i][j] == 0)
        {
          done = false;
        }
      }
    }
    */

    //Prepare next jump
    move(posx-1, posy-2, counter, done, n);
    move(posx+1, posy-2, counter, done, n);
    move(posx+2, posy-1, counter, done, n);
    move(posx+2, posy+1, counter, done, n);
    move(posx+1, posy+2, counter, done, n);
    move(posx-1, posy+2, counter, done, n);
    move(posx-2, posy-1, counter, done, n);
    move(posx-2, posy+1, counter, done, n);
    if (done){return;}
    counter--;
    knight--;
    board[posx][posy] = open;
    return;
}

public static void main()
{
  int counter = 0;
  int size=5;
  bool done = false;

  //Load the board
  load_board(board, size);
  print_board(board, counter, size);

  //Place the knight at the first square
  int startx = 0;
  int starty = 0;
  do{
  System.out.println("\nEnter starting x position for the knight - top left corner is 0,0")
  std::cin >> starty;
  System.out.println("Enter starting y position for the knight.");
  std::cin >> startx;}
  while (startx > size || startx < 0 || starty > size || starty < 0);

  //Get the solution
  move(startx+2,starty+2,counter, done, size);
  if (done)
  {
    print_board(board, counter, size);
    System.out.println("Finished!\n\n\n\n");
  }
  if (counter == 0)
  {
    System.out.println("Cannot complete (Hint: on a 5x5 board, not all squares are possible.)\n\n\n\n");
  }
  return 0;
}

}
}
