package model;

import java.util.Comparator;
/**CompareManager is a comparator for methond number 39 */
public class CompareManager implements Comparator<DepartmentManager>{

	public int compare(DepartmentManager o1, DepartmentManager o2) {
		if(o1.getSalary()==o2.getSalary()) {
			if(o1.getAppointmentDate().isBefore(o2.getAppointmentDate())) {
				return -1;
			}
			if(o2.getAppointmentDate().isBefore(o1.getAppointmentDate())) {
				return 1;
			}
			return o1.compareTo(o2);
		}
		if(o1.getSalary()>o2.getSalary()) {
			return 1;
		}
		
		return -1;
	}

}
