import logic.ConstantValues;
import logic.piece.Piece;
import logic.piece.StandardJunglePiece;


public class SwimmingPiece extends StandardJunglePiece{
	
	public SwimmingPiece(int side, int speed, int rank, java.lang.String name){
		super(side, speed, rank, name);
	}
	
	public boolean isSwimming(Piece piece){
		int row = piece.getLocation().getRow();
		int col = piece.getLocation().getColumn();
		boolean result = false;
		
		if((row == 3 || row == 4 || row == 5) && (col == 1 || col == 2 || col ==4 || col == 5)){
			result = true;
		}
		return result;
	}
	
}
