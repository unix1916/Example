package spring;

public class VersionPrinter {
	
	private int majorVersion;
	private int minorVersion;
	
	public void setMajor(int nVer) {
		this.majorVersion = nVer;
	}
	
	public void setMinor(int nVer) {
		this.minorVersion = nVer;
	}
	
	public void print() {
		System.out.printf("이 프로그램 버젼은 %d.%d 입니다.\n\n"
						, this.majorVersion
						, this.minorVersion);
	}

}
