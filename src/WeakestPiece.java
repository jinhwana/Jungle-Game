import logic.ConstantValues;
import logic.piece.Piece;

public class WeakestPiece extends SwimmingPiece{
	public WeakestPiece(int side, int speed, int rank, java.lang.String name) {
		super(side, speed, rank, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canTakePiece(Piece piece){
		if(piece == null){
			return true;
		}
		else if(piece.getRank() == ConstantValues.STRONGEST_PIECE_RANK){
			if(isSwimming(this)){
				return false;
			}
			return true;
		}
		else if(piece.getRank() == ConstantValues.WEAKEST_PIECE_RANK){
			if(isSwimming(this) && !isSwimming(piece)){
				return false;
			}
			return true;
		}
		else{
			return false;
		}
	}
}
