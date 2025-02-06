package app;

import java.util.HashMap;
import java.util.Map;

public class SchoolDetails {
	
	public static enum SchoolName {
	    OAKWOOD,
	    GREENFIELD,
	    RIVERSIDE,
	    HILLTOP,
	    SUNRISE
	}

	private static Map<SchoolName, Integer> schoolFees = new HashMap<>();

	static {
	    schoolFees.put(SchoolName.OAKWOOD, 75000);
	    schoolFees.put(SchoolName.GREENFIELD, 50000);
	    schoolFees.put(SchoolName.RIVERSIDE, 60000);
	    schoolFees.put(SchoolName.HILLTOP, 40000);
	    schoolFees.put(SchoolName.SUNRISE, 55000);
	}

    public static Integer getSchoolFees(SchoolName schoolName) {
        return schoolFees.get(schoolName);
    }
}
