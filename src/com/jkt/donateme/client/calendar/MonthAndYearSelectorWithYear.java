package com.jkt.donateme.client.calendar;

import java.util.Date;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.HTMLTable.CellFormatter;
import com.google.gwt.user.datepicker.client.CalendarModel;
import com.google.gwt.user.datepicker.client.MonthSelector;

public class MonthAndYearSelectorWithYear extends MonthSelector{

	
	private static String BASE_NAME = "datePicker";
    private PushButton backwards;
    private PushButton forwards;
    private PushButton backwardsYear;
    private PushButton forwardsYear;
    private Grid grid;
    private int previousYearColumn = 0;
    private int previousMonthColumn = 1;

    private int nextMonthColumn = 4;
    private int nextYearColumn = 5;
    private CalendarModel model;
    private DatePickerWithYearSelectorNew picker;

    private ListBox monthListBox;
    private ListBox yearListBox;

    public MonthAndYearSelectorWithYear() {

        yearListBox = new ListBox();

        for (int i = 1900; i <= 2099; i++) {
            yearListBox.addItem(i + "");
        }

        String[] items = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "Aug", "Sep", "Oct", "Nov", "Dec" };

        monthListBox = new ListBox();

        for (int i = 0; i < items.length; i++) {
            monthListBox.addItem(items[i]);
        }

    }

    public void setModel(CalendarModel model) {
        this.model = model;
    }

    public void setPicker(DatePickerWithYearSelectorNew picker) {
        this.picker = picker;
    }

    @Override
    protected void refresh() {
        int monthIndex = getModel().getCurrentMonth().getMonth();
        monthListBox.setItemSelected(monthIndex, true);
        int yearIndex = getModel().getCurrentMonth().getYear();
        // System.out.println(yearIndex);
        yearListBox.setItemSelected(yearIndex, true);
    }

    @Override
    protected void setup() {
        // Set up backwards.
        backwards = new PushButton();
        backwards.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                addMonths(-1);
            }
        });

        backwards.getUpFace().setHTML("&lsaquo;");
        backwards.setStyleName(BASE_NAME + "PreviousButton");

        forwards = new PushButton();
        forwards.getUpFace().setHTML("&rsaquo;");
        forwards.setStyleName(BASE_NAME + "NextButton");
        forwards.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (model.getCurrentMonth().getYear() < 1) {
                    addMonths(+1);
                }
                else if(model.getCurrentMonth().getMonth()<11 
                                     &&model.getCurrentMonth().getYear()==199)
                {
                    addMonths(+1);
                }
            }
        });

        // Set up backwards year
        backwardsYear = new PushButton();
        backwardsYear.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

                addMonths(-12);
                picker.refreshComponents();
            }
        });

        backwardsYear.getUpFace().setHTML("&laquo;");
        backwardsYear.setStyleName(BASE_NAME + "PreviousButton");

        forwardsYear = new PushButton();
        forwardsYear.getUpFace().setHTML("&raquo;");
        forwardsYear.setStyleName(BASE_NAME + "NextButton");
        forwardsYear.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (model.getCurrentMonth().getYear() < 199) {
                    addMonths(+12);
                    picker.refreshComponents();
                }
            }
        });

        yearListBox.addChangeHandler(new ChangeHandler() {

            
            public void onChange(ChangeEvent event) {
                int yearIndex = yearListBox.getSelectedIndex();
                     
              //setYear(Integer.parseInt(yearListBox.getValue(yearIndex)));
                setYear(yearIndex);
            }
        });
        monthListBox.addChangeHandler(new ChangeHandler() {

            
            public void onChange(ChangeEvent event) {
                int monthIndex = monthListBox.getSelectedIndex();
                setMonth(monthIndex);
            }
        });

        // Set up grid.
        grid = new Grid(1, 6);
        grid.setWidget(0, previousYearColumn, backwardsYear);
        grid.setWidget(0, previousMonthColumn, backwards);
        grid.setWidget(0, 2, monthListBox);
        grid.setWidget(0, 3, yearListBox);
        grid.setWidget(0, nextMonthColumn, forwards);
        grid.setWidget(0, nextYearColumn, forwardsYear);

        CellFormatter formatter = grid.getCellFormatter();

        formatter.setWidth(0, previousYearColumn, "1");
        formatter.setWidth(0, previousMonthColumn, "1");

        formatter.setWidth(0, nextMonthColumn, "1");
        formatter.setWidth(0, nextYearColumn, "1");
        grid.setStyleName(BASE_NAME + "MonthSelector");
        initWidget(grid);
    }

    public void addMonths(int numMonths) {
        model.shiftCurrentMonth(numMonths);
        picker.refreshComponents();
    }

    @SuppressWarnings("deprecation")
    public void setMonth(int month) {
        Date tempMonth = new Date();
        tempMonth.setMonth(month);

        model.setCurrentMonth(tempMonth);
        picker.refreshComponents();
    }

    @SuppressWarnings("deprecation")
    public void setYear(int year) {
        // to set year
        model.getCurrentMonth().setYear(year);
        picker.refreshComponents();
    }
}
