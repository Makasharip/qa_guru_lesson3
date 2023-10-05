package pages.Components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setdate(String day, String month, String year) {
        $(".react-datepicker__month-dropdown-container").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day
                + ":not(.react-datepicker__day--outside-month)").click();
    }
}
