package onzichtbaar.net.greaterThanFive6.load;

import java.util.ArrayList;

import onzichtbaar.net.greaterThanFive6.objects.Tile;

public class TilesLoad 
{

	private int grass = 1;
	private int wood = 2;
	private int town = 3;
	private int sheep = 4;
	private int desert = 5;
	
	private int grey = 10;
	private int green = 11;
	private int blue = 12;
	
	private Tile[] tile = new Tile[105];
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public TilesLoad()
	{
		tile[0] = null;
		
		tile[1] = new Tile( new Vector( -2560, 1536 ), wood ,  grey );
		tile[2] = new Tile( new Vector( -2048, 1536 ), wood ,  grey );
		tile[3] = new Tile( new Vector( -1536, 1536 ), wood ,  grey );
		tile[4] = new Tile( new Vector( -1024, 1536 ), wood ,  grey );
		tile[5] = new Tile( new Vector( -512, 1536 ), sheep ,  grey );
		tile[6] = new Tile( new Vector( 0, 1536 ), sheep ,  grey );
		tile[7] = new Tile( new Vector( 512, 1536 ), desert ,  grey );
		tile[8] = new Tile( new Vector( 1024, 1536 ), desert ,  grey );
		tile[9] = new Tile( new Vector( 1536, 1536 ), desert ,  grey );
		tile[10] = new Tile( new Vector( 2048, 1536 ), desert ,  grey );
		tile[11] = new Tile( new Vector( 2560, 1536 ), desert ,  grey );
		
		tile[12] = new Tile( new Vector( -2816, 1152 ), wood ,  grey );
		tile[13] = new Tile( new Vector( -2304, 1152 ), wood ,  grey );
		tile[14] = new Tile( new Vector( -1792, 1152 ), wood ,  grey );
		tile[15] = new Tile( new Vector( -1280, 1152 ), wood ,  grey );
		tile[16] = new Tile( new Vector( -768, 1152 ), wood ,  grey );
		tile[17] = new Tile( new Vector( -256, 1152 ), sheep ,  grey );
		tile[18] = new Tile( new Vector( 256, 1152 ), sheep ,  grey );
		tile[19] = new Tile( new Vector( 768, 1152 ), desert ,  grey );
		tile[20] = new Tile( new Vector( 1280, 1152 ), desert ,  grey );
		tile[21] = new Tile( new Vector( 1792, 1152 ), desert ,  grey );
		tile[22] = new Tile( new Vector( 2304, 1152 ), desert ,  grey );
		tile[23] = new Tile( new Vector( 2816, 1152 ), desert ,  grey );
		
		tile[24] = new Tile( new Vector( -2560, 768 ), wood ,  grey );
		tile[25] = new Tile( new Vector( -2048, 768 ), wood ,  grey );
		tile[26] = new Tile( new Vector( -1536, 768 ), wood ,  grey );
		tile[27] = new Tile( new Vector( -1024, 768 ), wood ,  grey );
		tile[28] = new Tile( new Vector( -512, 768 ), grass ,  green );
		tile[29] = new Tile( new Vector( 0, 768 ), wood ,  green );
		tile[30] = new Tile( new Vector( 512, 768 ), grass ,  grey );
		tile[31] = new Tile( new Vector( 1024, 768 ), desert ,  grey );
		tile[32] = new Tile( new Vector( 1536, 768 ), desert ,  grey );
		tile[33] = new Tile( new Vector( 2048, 768 ), desert ,  grey );
		tile[34] = new Tile( new Vector( 2560, 768 ), desert ,  grey );
		
		tile[35] = new Tile( new Vector( -2816, 384 ), grass ,  grey );
		tile[36] = new Tile( new Vector( -2304, 384 ), wood ,  grey );
		tile[37] = new Tile( new Vector( -1792, 384 ), wood ,  grey );
		tile[38] = new Tile( new Vector( -1280, 384 ), wood ,  grey );
		tile[39] = new Tile( new Vector( -768, 384 ), grass ,  green );
		tile[40] = new Tile( new Vector( -256, 384 ), town ,  green );
		tile[41] = new Tile( new Vector( 256, 384 ), wood ,  green );
		tile[42] = new Tile( new Vector( 768, 384 ), desert ,  green );
		tile[43] = new Tile( new Vector( 1280, 384 ), grass ,  grey );
		tile[44] = new Tile( new Vector( 1792, 384 ), desert ,  grey );
		tile[45] = new Tile( new Vector( 2304, 384 ), grass ,  grey );
		tile[46] = new Tile( new Vector( 2816, 384 ), grass ,  grey );
		
		tile[47] = new Tile( new Vector( -2560, 0 ), wood ,  grey );
		tile[48] = new Tile( new Vector( -2048, 0 ), wood ,  grey );
		tile[49] = new Tile( new Vector( -1536, 0 ), grass ,  grey );
		tile[50] = new Tile( new Vector( -1024, 0 ), grass ,  grey );
		tile[51] = new Tile( new Vector( -512, 0 ), sheep ,  green );
		tile[52] = new Tile( new Vector( 0, 0 ), grass ,  green );
		tile[53] = new Tile( new Vector( 512, 0 ), grass ,  green );
		tile[54] = new Tile( new Vector( 1024, 0 ), grass ,  grey );
		tile[55] = new Tile( new Vector( 1536, 0 ), desert ,  grey );
		tile[56] = new Tile( new Vector( 2048, 0 ), desert ,  grey );
		tile[57] = new Tile( new Vector( 2560, 0 ), wood ,  grey );
		
		tile[58] = new Tile( new Vector( -2816, -384 ), grass ,  grey );
		tile[59] = new Tile( new Vector( -2304, -384 ), grass ,  grey );
		tile[60] = new Tile( new Vector( -1792, -384 ), grass ,  grey );
		tile[61] = new Tile( new Vector( -1280, -384 ), grass ,  grey );
		tile[62] = new Tile( new Vector( -768, -384 ), grass ,  grey );
		tile[63] = new Tile( new Vector( -256, -384 ), grass ,  grey );
		tile[64] = new Tile( new Vector( 256, -384 ), grass ,  grey );
		tile[65] = new Tile( new Vector( 768, -384 ), grass ,  grey );
		tile[66] = new Tile( new Vector( 1280, -384 ), sheep ,  grey );
		tile[67] = new Tile( new Vector( 1792, -384 ), sheep ,  grey );
		tile[68] = new Tile( new Vector( 2304, -384 ), wood ,  grey );
		tile[69] = new Tile( new Vector( 2816, -384 ), wood ,  grey );
		
		tile[70] = new Tile( new Vector( -2560, -768 ), grass ,  grey );
		tile[71] = new Tile( new Vector( -2048, -768 ), grass ,  grey );
		tile[72] = new Tile( new Vector( -1536, -768 ), grass ,  grey );
		tile[73] = new Tile( new Vector( -1024, -768 ), grass ,  grey );
		tile[74] = new Tile( new Vector( -512, -768 ), grass ,  grey );
		tile[75] = new Tile( new Vector( 0, -768 ), sheep ,  grey );
		tile[76] = new Tile( new Vector( 512, -768 ), sheep ,  grey );
		tile[77] = new Tile( new Vector( 1024, -768 ), sheep ,  grey );
		tile[78] = new Tile( new Vector( 1536, -768 ), wood ,  grey );
		tile[79] = new Tile( new Vector( 2048, -768 ), wood ,  grey );
		tile[80] = new Tile( new Vector( 2560, -768 ), wood ,  grey );
		
		tile[81] = new Tile( new Vector( -2816, -1152 ), grass ,  grey );
		tile[82] = new Tile( new Vector( -2304, -1152 ), grass ,  grey );
		tile[83] = new Tile( new Vector( -1792, -1152 ), grass ,  grey );
		tile[84] = new Tile( new Vector( -1280, -1152 ), grass ,  grey );
		tile[85] = new Tile( new Vector( -768, -1152 ), sheep ,  grey );
		tile[86] = new Tile( new Vector( -256, -1152 ), sheep ,  grey );
		tile[87] = new Tile( new Vector( 256, -1152 ), sheep ,  grey );
		tile[88] = new Tile( new Vector( 768, -1152 ), sheep ,  grey );
		tile[89] = new Tile( new Vector( 1280, -1152 ), sheep ,  grey );
		tile[90] = new Tile( new Vector( 1792, -1152 ), wood ,  grey );
		tile[91] = new Tile( new Vector( 2304, -1152 ), wood ,  grey );
		tile[92] = new Tile( new Vector( 2816, -1152 ), wood ,  grey );
		
		tile[93] = new Tile( new Vector( -2560, -1536 ), grass ,  grey );
		tile[94] = new Tile( new Vector( -2048, -1536 ), grass ,  grey );
		tile[95] = new Tile( new Vector( -1536, -1536 ), grass ,  grey );
		tile[96] = new Tile( new Vector( -1024, -1536 ), grass ,  grey );
		tile[97] = new Tile( new Vector( -512, -1536 ), grass ,  grey );
		tile[98] = new Tile( new Vector( 0, -1536 ), sheep ,  grey );
		tile[99] = new Tile( new Vector( 512, -1536 ), sheep ,  grey );
		tile[100] = new Tile( new Vector( 1024, -1536 ), sheep ,  grey );
		tile[101] = new Tile( new Vector( 1536, -1536 ), sheep ,  grey );
		tile[102] = new Tile( new Vector( 2048, -1536 ), wood ,  grey );
		tile[103] = new Tile( new Vector( 2560, -1536 ), wood ,  grey );
		
		for( int i = 0; i < 104; i++ )
		{
			tiles.add(tile[i] );
		}
	}

	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
}
