import logic.ConstantValues;
import logic.Coordinate;
import logic.piece.Piece;
import logic.tile.Tile;

public class TrapTile extends Tile{
	
	private int _side;
	
	public TrapTile(Coordinate location){
		super(location);
	}
	
	public TrapTile(Coordinate location, java.lang.String name, int _side){
		super(location, name);
		this._side = _side;
	}
	
	@Override
	public Piece placePiece(Piece piece){
		if(piece.getSide() != _side)
			piece.setRank(ConstantValues.ON_TRAP);
		return super.placePiece(piece);
	}
	
	@Override
	public Piece removePiece(){
		if(getPlacedPiece() != null){
			getPlacedPiece().resetRank();
		}
		
		return super.removePiece();
	}
}
