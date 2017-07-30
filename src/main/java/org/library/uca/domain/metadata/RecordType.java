package org.library.uca.domain.metadata;

public enum RecordType {

    OLD("old"), 
	EBOOK("ebook"), 
    REPRINT("reprint"),
    MANUAL("manual"), 
    MAGAZINE("magazine"),
    MONOGRAPH("monograph"), 
    MINUTES("minutes"), 
    TRIBUTES("tributes"), 
    AGREEMENT("agreement"), 
    TRANSLATION("translation"), 
    INSTITUTIONAL("institutional"), 
    ADMINISTRATIVE("administrative");
	
	private String value;

	private RecordType(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
