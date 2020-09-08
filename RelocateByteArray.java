public class RelocateByteArray {
	private byte[] imageArray;
	private byte[] r;
	private byte[] g;
	private byte[] b;
	private byte[] relocateArray;

	public RelocateByteArray(byte[] imageArray) {
		this.imageArray = new byte[387000];
		this.imageArray = imageArray;
		this.r = new byte[129150];
		this.g = new byte[129150];
		this.b = new byte[129150];
		this.relocateArray = new byte[387450];
	}

	private void SplitRGB() {
		int flag = 3;
		int r = 0;
		int g = 0;
		int b = 0;
		for (int k = 1; k <= 387000; k++) {
			if (flag % 3 == 0) {
				this.r[r++] = this.imageArray[k - 1];
			} else if (flag % 3 == 1) {
				this.g[g++] = this.imageArray[k - 1];
			} else {
				this.b[b++] = this.imageArray[k - 1];
			}

			if (k % 860 == 0) {
				if (flag % 3 == 0) {
					this.r[r++] = (byte) 0;
				} else if (flag % 3 == 1) {
					this.g[g++] = (byte) 0;
				} else {
					this.b[b++] = (byte) 0;
				}
				flag++;
			}

		}
	}

	private void RelocateArray() { 
		int flag = 0;
		int r = 0;
		int g = 0;
		int b = 0;
		for( int k = 0; k < 387450; k++) { 
			if( flag % 3 == 0) {
				this.relocateArray[k] = this.b[b++];
			}
			else if( flag % 3 == 1) {
				this.relocateArray[k] = this.g[g++];
			}
			else {
				this.relocateArray[k] = this.r[r++];
			}
			flag++;
		}
	}
	
	public byte[] StartRelocateByteArray() {
		SplitRGB();
		RelocateArray();
		
		return relocateArray;
	}
}
