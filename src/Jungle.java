/*
 Name: Jin Hwan Oh
 Student Number: 991 381 235
 Project: Jungle
 Program: Computer Programmer
 
 Description:
	Objective    
	 	The goal of the game is either to capture all of the opponents 
	 	pieces or to reach the den of the opponent. Performing either of 
	 	these tasks before the opponent results in a victory for you. 

	Board   
		The game is a 7 by 9 board of tiles. 
		Pieces can move into another space provided, not on the lines. 
		Pieces move one square at a time in any direction apart from angles. 
		
	Pieces   
		Pieces have rank, therefore a rank higher than or equal 
		to a rank of another piece may be taken. The exception to this 
		rule is the elephant which cannot take the rat.  
 */

import view.GameView;
import logic.ConstantValues;
import logic.Coordinate;
import logic.Game;
import logic.GameBoard;
import logic.piece.StandardJunglePiece;
import logic.tile.Tile;

public class Jungle extends Game{
	public static Tile[][] tile;
	public static GameBoard gb;
	int size = _redPieces.size() / 2;
	@Override
	public int whoWon(){

		if(tile[0][3].getPlacedPiece() != null 
				&& tile[0][3].getPlacedPiece().getSide() == ConstantValues.RED_SIDE){
			return ConstantValues.RED_SIDE;
		}
		else if(tile[8][3].getPlacedPiece() != null 
				&& tile[8][3].getPlacedPiece().getSide() == ConstantValues.BLACK_SIDE){
			return ConstantValues.BLACK_SIDE;
		}
		else{
			return super.whoWon();
		}
	}

	@Override
	public void initBoard(){
		tile = new Tile[ConstantValues.ROWS][ConstantValues.COLUMNS];
		for(int i = 3; i < 6; i++){
			for(int j = 1; j < 3; j++){
				tile[i][j] = new WaterTile(new Coordinate(i, j), "Water");
			}
		}

		for(int i = 3; i < 6; i++){
			for(int j = 4; j < 6; j++){
				tile[i][j] = new WaterTile(new Coordinate(i, j), "Water");
			}
		}

		tile[0][2] = new TrapTile(new Coordinate(0, 2), "Trap", ConstantValues.BLUE_SIDE);
		tile[0][4] = new TrapTile(new Coordinate(0, 4), "Trap", ConstantValues.BLUE_SIDE);
		tile[1][3] = new TrapTile(new Coordinate(1, 3), "Trap", ConstantValues.BLUE_SIDE);

		tile[8][2] = new TrapTile(new Coordinate(8, 2), "Trap", ConstantValues.RED_SIDE);
		tile[8][4] = new TrapTile(new Coordinate(8, 4), "Trap", ConstantValues.RED_SIDE);
		tile[7][3] = new TrapTile(new Coordinate(7, 3), "Trap", ConstantValues.RED_SIDE);

		tile[0][3] = new DenTile(new Coordinate(0, 3), "Den");
		tile[8][3] = new DenTile(new Coordinate(8, 3), "Den");
		for(int i = 0; i < ConstantValues.ROWS; i++){
			for(int j = 0; j < ConstantValues.COLUMNS; j++){
				if(tile[i][j] == null)
					tile[i][j] = new Tile(new Coordinate(i, j), "Tile");
			}
		}
		super._gameBoard = new GameBoard(tile);
	}

	@Override
	public void initPieces(){
		_redPieces.clear();
		_blackPieces.clear();
		
		WeakestPiece ratPieceRed = new WeakestPiece(ConstantValues.RED_SIDE, 0, ConstantValues.GAMEPIECE_RAT + 1, "Rat");
		StandardJunglePiece catPieceRed = new StandardJunglePiece(ConstantValues.RED_SIDE, 0, ConstantValues.GAMEPIECE_CAT + 1 , "Cat");
		StandardJunglePiece dogPieceRed = new StandardJunglePiece(ConstantValues.RED_SIDE, 0, ConstantValues.GAMEPIECE_DOG + 1, "Dog");
		StandardJunglePiece wolfPieceRed = new StandardJunglePiece(ConstantValues.RED_SIDE, 0, ConstantValues.GAMEPIECE_WOLF + 1, "Wolf");
		StandardJunglePiece leopardPieceRed = new StandardJunglePiece(ConstantValues.RED_SIDE, 0, ConstantValues.GAMEPIECE_LEOPARD + 1, "Leopard");
		StandardJunglePiece tigerPieceRed = new StandardJunglePiece(ConstantValues.RED_SIDE, 0, ConstantValues.GAMEPIECE_TIGER + 1, "Tiger");
		StandardJunglePiece lionPieceRed = new StandardJunglePiece(ConstantValues.RED_SIDE, 0, ConstantValues.GAMEPIECE_LION + 1, "Lion");
		StrongestPiece elephantPieceRed = new StrongestPiece(ConstantValues.RED_SIDE, 0, ConstantValues.GAMEPIECE_ELEPHANT + 1, "Elephant");
		_redPieces.add(ratPieceRed);
		_redPieces.add(catPieceRed);
		_redPieces.add(dogPieceRed);
		_redPieces.add(wolfPieceRed);
		_redPieces.add(leopardPieceRed);
		_redPieces.add(tigerPieceRed);
		_redPieces.add(lionPieceRed);
		_redPieces.add(elephantPieceRed);
		
		
		WeakestPiece ratPieceBlue = new WeakestPiece(ConstantValues.BLUE_SIDE, 0, ConstantValues.GAMEPIECE_RAT + 1, "Rat");
		StandardJunglePiece catPieceBlue = new StandardJunglePiece(ConstantValues.BLUE_SIDE, 0, ConstantValues.GAMEPIECE_CAT + 1, "Cat");
		StandardJunglePiece dogPieceBlue = new StandardJunglePiece(ConstantValues.BLUE_SIDE, 0, ConstantValues.GAMEPIECE_DOG + 1, "Dog");
		StandardJunglePiece wolfPieceBlue = new StandardJunglePiece(ConstantValues.BLUE_SIDE, 0, ConstantValues.GAMEPIECE_WOLF + 1, "Wolf");
		StandardJunglePiece leopardPieceBlue = new StandardJunglePiece(ConstantValues.BLUE_SIDE, 0, ConstantValues.GAMEPIECE_LEOPARD + 1, "Leopard");
		StandardJunglePiece tigerPieceBlue = new StandardJunglePiece(ConstantValues.BLUE_SIDE, 0, ConstantValues.GAMEPIECE_TIGER + 1, "Tiger");
		StandardJunglePiece lionPieceBlue = new StandardJunglePiece(ConstantValues.BLUE_SIDE, 0, ConstantValues.GAMEPIECE_LION + 1, "Lion");
		StrongestPiece elephantPieceBlue = new StrongestPiece(ConstantValues.BLUE_SIDE, 0, ConstantValues.GAMEPIECE_ELEPHANT + 1, "Elephant");
		_blackPieces.add(ratPieceBlue);
		_blackPieces.add(catPieceBlue);
		_blackPieces.add(dogPieceBlue);
		_blackPieces.add(wolfPieceBlue);
		_blackPieces.add(leopardPieceBlue);
		_blackPieces.add(tigerPieceBlue);
		_blackPieces.add(lionPieceBlue);
		_blackPieces.add(elephantPieceBlue);
		
		getTile(2, 0).placePiece(ratPieceBlue);
		getTile(1, 5).placePiece(catPieceBlue);
		getTile(1, 1).placePiece(dogPieceBlue);
		getTile(2, 4).placePiece(wolfPieceBlue);
		getTile(2, 2).placePiece(leopardPieceBlue);
		getTile(0, 6).placePiece(tigerPieceBlue);
		getTile(0, 0).placePiece(lionPieceBlue);
		getTile(2, 6).placePiece(elephantPieceBlue);

		getTile(6, 6).placePiece(ratPieceRed);
		getTile(7, 1).placePiece(catPieceRed);
		getTile(7, 5).placePiece(dogPieceRed);
		getTile(6, 2).placePiece(wolfPieceRed);
		getTile(6, 4).placePiece(leopardPieceRed);
		getTile(8, 0).placePiece(tigerPieceRed); 
		getTile(8, 6).placePiece(lionPieceRed);
		getTile(6, 0).placePiece(elephantPieceRed);

	}

	public static void main(String[] args){
		Game jungle = new Jungle();
		jungle.initBoard();
		jungle.initPieces();
		GameView gv = new GameView(jungle);
	}
}