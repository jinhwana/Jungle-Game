import logic.ConstantValues;
import logic.piece.Piece;
import logic.piece.StandardJunglePiece;


public class StrongestPiece extends StandardJunglePiece{
	public StrongestPiece(int side, int speed, int rank, String name) {
		super(side, speed, rank, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canTakePiece(Piece piece){
		if(piece == null){
			return true;
		}
		else if(piece.getRank() == ConstantValues.WEAKEST_PIECE_RANK){
			return false;
		}
		else{
			return true;
		}
	}
	
}