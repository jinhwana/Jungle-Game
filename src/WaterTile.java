import logic.ConstantValues;
import logic.Coordinate;
import logic.piece.Piece;
import logic.tile.Tile;

public class WaterTile extends Tile{
	public WaterTile(Coordinate location){
		super(location);
	}
	
	public WaterTile(Coordinate location, java.lang.String name){
		super(location, name);
	}
	
	@Override
	public boolean canPieceEnter(Piece piece){
		if(piece.getRank() == ConstantValues.GAMEPIECE_RAT + 1){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean canJumpOver(Piece piece){
		if(piece == null){
			return false;
		}
		else if(getPlacedPiece() == null && ((piece.getRank() == ConstantValues.GAMEPIECE_LION + 1) ||
				piece.getRank() == ConstantValues.GAMEPIECE_TIGER + 1)){
					return true;
				}
		
		return false;
	}
}
