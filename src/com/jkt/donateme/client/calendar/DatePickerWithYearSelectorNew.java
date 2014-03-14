package com.jkt.donateme.client.calendar;

import com.google.gwt.user.datepicker.client.CalendarModel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.datepicker.client.DefaultCalendarView;

public class DatePickerWithYearSelectorNew extends DatePicker{
	public DatePickerWithYearSelectorNew() {
        super(new MonthAndYearSelectorWithYear(), new DefaultCalendarView(),
                new CalendarModel());
    MonthAndYearSelectorWithYear monthSelector = (MonthAndYearSelectorWithYear)            
this.getMonthSelector();
        monthSelector.setPicker(this);
            monthSelector.setModel(this.getModel());
    }
    public void refreshComponents() {
        super.refreshAll();
    }

}
