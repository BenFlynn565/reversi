package uk.co.benflynn.reversi.utils;

import uk.co.benflynn.reversi.Reversi;

public class MoveValidator {
	
	private Reversi main = new Reversi();
	private boolean north, northeast, east, southeast, south, southwest, west, northwest;
	private int northInt, northeastIntR, northeastIntC, eastInt, southeastIntC, southeastIntR, southInt, southwestIntC, southwestIntR, westInt, northwestIntC, northwestIntR;
	
	public int isValidWhite(int row, int col) {
		north = northeast = east = southeast = south = southwest = west = northwest = false;
		
		if(row == 0) {
			if(col == 0) {
				if(main.board[row+1][col] == 2) {
					south = true;
				}
				if(main.board[row][col+1] == 2) {
					east = true;
				}
				if(main.board[row+1][col+1] == 2) {
					southeast = true;
				}
			} else if(col == 7) {
				if(main.board[row+1][col] == 2) {
					south = true;
				}
				if(main.board[row][col-1] == 2) {
					west = true;
				}
				if(main.board[row+1][col-1] == 2) {
					southwest = true;
				}
			} else {
				if(main.board[row][col-1] == 2) {
					west = true;
				}
				if(main.board[row+1][col-1] == 2) {
					southwest = true;
				}
				if(main.board[row+1][col] == 2) {
					south = true;
				}
				if(main.board[row+1][col+1] == 2) {
					southeast= true;
				}
				if(main.board[row][col+1] == 2) {
					east = true;
				}
			}
		} else if(row == 7) {
			if(col == 0) {
				if(main.board[row-1][col] == 2) {
					north = true;
				}
				if(main.board[row][col+1] == 2) {
					east = true;
				}
				if(main.board[row-1][col+1] == 2) {
					northeast = true;
				}
			} else if(col == 7) {
				if(main.board[row-1][col] == 2) {
					north = true;
				}
				if(main.board[row][col-1] == 2) {
					west = true;
				}
				if(main.board[row-1][col-1] == 2) {
					northwest = true;
				}
			} else {
				if(main.board[row][col-1] == 2) {
					west = true;
				}
				if(main.board[row-1][col-1] == 2) {
					northwest = true;
				}
				if(main.board[row-1][col] == 2) {
					north = true;
				}
				if(main.board[row-1][col+1] == 2) {
					northeast = true;
				}
				if(main.board[row][col+1] == 2) {
					east = true;
				}
			}
		} else if (col == 0) {
			if(main.board[row-1][col] == 2) {
				north = true;
			}
			if(main.board[row-1][col+1] == 2) {
				northeast = true;
			}
			if(main.board[row][col+1] == 2) {
				east = true;
			}
			if(main.board[row+1][col+1] == 2) {
				southeast = true;
			}
			if(main.board[row+1][col] == 2) {
				south = true;
			}
		} else if (col == 7) {
			if(main.board[row-1][col] == 2) {
				north = true;
			}
			if(main.board[row-1][col-1] == 2) {
				northwest = true;
			}
			if(main.board[row][col-1] == 2) {
				west = true;
			}
			if(main.board[row+1][col-1] == 2) {
				southwest = true;
			}
			if(main.board[row+1][col] == 2) {
				south = true;
			}
		} else {
			if(main.board[row-1][col-1] == 2) {
				southeast = true;
			}
			if(main.board[row-1][col] == 2) {
				north = true;
			}
			if(main.board[row-1][col+1] == 2) {
				System.out.println("test2");
				northeast = true;
			}
			if(main.board[row][col+1] == 2) {
				east = true;
			}
			if(main.board[row+1][col+1] == 2) {
				northwest = true;
			}
			if(main.board[row+1][col] == 2) {
				System.out.println("test");
				south = true;
			}
			if(main.board[row+1][col-1] == 2) {
				southwest = true;
			}
			if(main.board[row][col-1] == 2) {
				west = true;
			}
		}
		
		System.out.println(northwest + "  " + north + "  " + northeast);
		System.out.println(west + "   " + "      " + east);
		System.out.println(southwest + "  " + south + "  " + southeast);
		
		
		if(north) {
			System.out.println(1);
			for(northInt = row-1; northInt >= 0; northInt--) {
				if(main.board[northInt][col] == 0 || main.board[northInt][col] == 1) {
					break;
				}
			}
		}
		if(northeast) {
			System.out.println(2);
			for(northeastIntR = row-1; northeastIntR >= 0; northeastIntR--) {
				for(northeastIntC = col+1; northeastIntC >= 7; northeastIntC++) {
					if(main.board[northeastIntR][northeastIntC] == 0 || main.board[northeastIntR][northeastIntC] == 1) {
						break;
					}
				}
			}
		}
		if(east) {
			System.out.println(3);
			for(eastInt = col+1; eastInt >= 7; eastInt++) {
				if(main.board[row][eastInt] == 0 || main.board[row][eastInt] == 1) {
					break;
				}
			}
		}
		if(southeast) {
			System.out.println(4);
			for(southeastIntR = row+1; southeastIntR >= 7; southeastIntR++) {
				for(southeastIntC = col+1; southeastIntC >= 7; southeastIntC++) {
					if(main.board[southeastIntR][southeastIntC] == 0 || main.board[southeastIntR][southeastIntC] == 1) {
						break;
					}
				}
			}
		}
		if(south) {
			System.out.println(5);
			for(southInt = row+1; southInt >= 7; southInt++) {
				if(main.board[southInt][col] == 0 || main.board[southInt][col] == 1) {
					break;
					
					//test
				}
			}
		}
		if(southwest) {
			System.out.println(6);
			for(southwestIntR = row+1; southwestIntR >= 7; southwestIntR++) {
				for(southwestIntC = col-1; southwestIntC >= 0; southwestIntC--) {
					if(main.board[southwestIntR][southwestIntC] == 0 || main.board[southwestIntR][southwestIntC] == 1) {
						break;
					}
				}
			}
		}
		if(west) {
			System.out.println(7);
			for(westInt = col-1; westInt >= 0; westInt--) {
				if(main.board[row][westInt] == 0 || main.board[row][westInt] == 1) {
					break;
				}
			}
		}
		if(northwest) {
			System.out.println(8);
			for(northwestIntR = row-1; northwestIntR >= 0; northwestIntR--) {
				for(northwestIntC = col-1; northwestIntC >= 0; northwestIntC--) {
					if(main.board[northwestIntR][northwestIntC] == 0 || main.board[northwestIntR][northwestIntC] == 1) {
						break;
					}
				}
			}
		}
		
		int highest = Math.max(northInt, Math.max(col+northeastIntC, Math.max(eastInt, Math.max(col-southeastIntC, Math.max(southInt, Math.max(col-southwestIntC, Math.max(westInt, col+northwestIntC)))))));

		
		if(highest == northInt) {
			System.out.println("north");
			return 2;
		}
		if(highest == col+northeastIntC) {
			System.out.println("northeast");
			return 3;
		}
		if(highest == eastInt) {
			System.out.println("east");
			return 4;
		}
		if(highest == col-southeastIntC) {
			System.out.println("southeast");
			return 5;
		}
		if(highest == southInt) {
			System.out.println("south");
			return 6;
		}
		if(highest == col-southwestIntC) {
			System.out.println("southwest");
			return 7;
		}
		if(highest == westInt) {
			System.out.println("west");
			return 8;
		}
		if(highest == col+northwestIntC) {
			System.out.println("northwest");
			return 1;
		}
		return 0;
	}

	public int isValidBlack(int row, int col) {
		north = northeast = east = southeast = south = southwest = west = northwest = false;
		
		if(row == 0) {
			if(col == 0) {
				if(main.board[row+1][col] == 1) {
					south = true;
				}
				if(main.board[row][col+1] == 1) {
					east = true;
				}
				if(main.board[row+1][col+1] == 1) {
					southeast = true;
				}
			} else if(col == 7) {
				if(main.board[row+1][col] == 1) {
					south = true;
				}
				if(main.board[row][col-1] == 1) {
					west = true;
				}
				if(main.board[row+1][col-1] == 1) {
					southwest = true;
				}
			} else {
				if(main.board[row][col-1] == 1) {
					west = true;
				}
				if(main.board[row+1][col-1] == 1) {
					southwest = true;
				}
				if(main.board[row+1][col] == 1) {
					south = true;
				}
				if(main.board[row+1][col+1] == 1) {
					southeast= true;
				}
				if(main.board[row][col+1] == 1) {
					east = true;
				}
			}
		} else if(row == 7) {
			if(col == 0) {
				if(main.board[row-1][col] == 1) {
					north = true;
				}
				if(main.board[row][col+1] == 1) {
					east = true;
				}
				if(main.board[row-1][col+1] == 1) {
					northeast = true;
				}
			} else if(col == 7) {
				if(main.board[row-1][col] == 1) {
					north = true;
				}
				if(main.board[row][col-1] == 1) {
					west = true;
				}
				if(main.board[row-1][col-1] == 1) {
					northwest = true;
				}
			} else {
				if(main.board[row][col-1] == 1) {
					west = true;
				}
				if(main.board[row-1][col-1] == 1) {
					northwest = true;
				}
				if(main.board[row-1][col] == 1) {
					north = true;
				}
				if(main.board[row-1][col+1] == 1) {
					northeast = true;
				}
				if(main.board[row][col+1] == 1) {
					east = true;
				}
			}
		} else if (col == 0) {
			if(main.board[row-1][col] == 1) {
				north = true;
			}
			if(main.board[row-1][col+1] == 1) {
				northeast = true;
			}
			if(main.board[row][col+1] == 1) {
				east = true;
			}
			if(main.board[row+1][col+1] == 1) {
				southeast = true;
			}
			if(main.board[row+1][col] == 1) {
				south = true;
			}
		} else if (col == 7) {
			if(main.board[row-1][col] == 1) {
				north = true;
			}
			if(main.board[row-1][col-1] == 1) {
				northwest = true;
			}
			if(main.board[row][col-1] == 1) {
				west = true;
			}
			if(main.board[row+1][col-1] == 1) {
				southwest = true;
			}
			if(main.board[row+1][col] == 1) {
				south = true;
			}
		} else {
			if(main.board[row-1][col-1] == 1) {
				southeast = true;
			}
			if(main.board[row-1][col] == 1) {
				north = true;
			}
			if(main.board[row-1][col+1] == 1) {
				northeast = true;
			}
			if(main.board[row][col+1] == 1) {
				east = true;
			}
			if(main.board[row+1][col+1] == 1) {
				northwest = true;
			}
			if(main.board[row+1][col] == 1) {
				south = true;
			}
			if(main.board[row+1][col-1] == 1) {
				southwest = true;
			}
			if(main.board[row][col-1] == 1) {
				west = true;
			}
		}
		
		System.out.println(northwest + "  " + north + "  " + northeast);
		System.out.println(west + "   " + "      " + east);
		System.out.println(southwest + "  " + south + "  " + southeast);
		
		
		if(north) {
			System.out.println(1);
			for(northInt = row-1; northInt >= 0; northInt--) {
				if(main.board[northInt][col] == 0 || main.board[northInt][col] == 2) {
					break;
				}
			}
		}
		if(northeast) {
			System.out.println(2);
			for(northeastIntR = row-1; northeastIntR >= 0; northeastIntR--) {
				for(northeastIntC = col+1; northeastIntC >= 7; northeastIntC++) {
					if(main.board[northeastIntR][northeastIntC] == 0 || main.board[northeastIntR][northeastIntC] == 2) {
						break;
					}
				}
			}
		}
		if(east) {
			System.out.println(3);
			for(eastInt = col+1; eastInt >= 7; eastInt++) {
				if(main.board[row][eastInt] == 0 || main.board[row][eastInt] == 2) {
					break;
				}
			}
		}
		if(southeast) {
			System.out.println(4);
			for(southeastIntR = row+1; southeastIntR >= 7; southeastIntR++) {
				for(southeastIntC = col+1; southeastIntC >= 7; southeastIntC++) {
					if(main.board[southeastIntR][southeastIntC] == 0 || main.board[southeastIntR][southeastIntC] == 2) {
						break;
					}
				}
			}
		}
		if(south) {
			System.out.println(5);
			for(southInt = row+1; southInt >= 7; southInt++) {
				if(main.board[southInt][col] == 0 || main.board[southInt][col] == 2) {
					break;
				}
			}
		}
		if(southwest) {
			System.out.println(6);
			for(southwestIntR = row+1; southwestIntR >= 7; southwestIntR++) {
				for(southwestIntC = col-1; southwestIntC >= 0; southwestIntC--) {
					if(main.board[southwestIntR][southwestIntC] == 0 || main.board[southwestIntR][southwestIntC] == 2) {
						break;
					}
				}
			}
		}
		if(west) {
			System.out.println(7);
			for(westInt = col-1; westInt >= 0; westInt--) {
				if(main.board[row][westInt] == 0 || main.board[row][westInt] == 2) {
					break;
				}
			}
		}
		if(northwest) {
			System.out.println(8);
			for(northwestIntR = row-1; northwestIntR >= 0; northwestIntR--) {
				for(northwestIntC = col-1; northwestIntC >= 0; northwestIntC--) {
					if(main.board[northwestIntR][northwestIntC] == 0 || main.board[northwestIntR][northwestIntC] == 2) {
						break;
					}
				}
			}
		}
		
		int highest = Math.max(northInt, Math.max(col+northeastIntC, Math.max(eastInt, Math.max(col-southeastIntC, Math.max(southInt, Math.max(col-southwestIntC, Math.max(westInt, col+northwestIntC)))))));

		
		if(highest == northInt) {
			System.out.println("north");
			return 2;
		}
		if(highest == col+northeastIntC) {
			System.out.println("northeast");
			return 3;
		}
		if(highest == eastInt) {
			System.out.println("east");
			return 4;
		}
		if(highest == col-southeastIntC) {
			System.out.println("southeast");
			return 5;
		}
		if(highest == southInt) {
			System.out.println("south");
			return 6;
		}
		if(highest == col-southwestIntC) {
			System.out.println("southwest");
			return 7;
		}
		if(highest == westInt) {
			System.out.println("west");
			return 8;
		}
		if(highest == col+northwestIntC) {
			System.out.println("northwest");
			return 1;
		}
		return 0;
	}
}
