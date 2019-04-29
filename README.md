# CS151_FinalProject

Discription:
In this project, you will design and implement two separate frames. The first frame is a calendar.
The second frame has the to-do list for each day you click on the calendar. You should also be
able to see your to-do list for the entire month if you click on the month on the calendar. In order to
complete this project you should apply concepts you have learnt from this course on the project.
However, for some of the topics, you may have to learn through self-study in order to complete the
project – this is an essential part of becoming successful in programming.
An initial screen of the calendar is shown in figure 1. You are allowed to design the look and feel of
your to-do list differently as long as it satisfies the “minimum” requirements described below. Make
a Day view default in the initial screen.

The first frame 
• Your design has to follow the design pattern.
• Current calendar should be as you see in Figure 1 (frame1) on the left. Each date should be
clickable. When you click on a particular date, the current view on frame 2 will change
accordingly.
• The current calendar also comes with two buttons to navigate the current calendar back and
forth by month. It also has a small menu to choose the year. During this navigation, the
selected view is not changing. The navigation can go as far as the Gregorian Calendar can
make it.
• There is a label at the bottom of the calendar that shows the current day.
• The days that are not related to the current month should appear in grey color. For example,
the days after January 31st are in grey color in Figure 1.
• The to-do list as you see at Figure 1 (frame2). This frame presents the list of tasks for any
day you click on.
• There is a list of tasks for each day. Implement the scroll bar in that area.
Today: April 2, 2019
Day: Monday 1,27,2014
Delete Task Edit Task Add Task
Book Flight to NYC
Haircut
Review CS166
Meet friends
Do CS151 homework
Work on project
Do shopping
Fame 1 Fame 2
Export
3
• In Frame 2, current view of day, week, or month depending on the currently selected view.
The selected day should appear as a label at the top of the list as shown in Figure 1.
• Frame 2 has four buttons:
o Add Task button: adds one task to the todo list of the day. There is a text area at the
top of the three buttons to type the task.
o Edit Task and Delete Task only work if you have one of the tasks highlighted at the
list.
o Edit task Button: After choosing one task, you can edit it by typing the new task in
the text area and hit Enter on the keyboard.
o Delete Task Button: After choosing one task, you can click on Delete Task. The task
will be removed from the list. Reprint the entire list to close any gap the deletion
might cause.
o Export Button: this button will export all the tasks of the current “month” into a .txt file.
The name of the file will be month_year.txt, for example “January_2013.txt”. Note
that.txt will contain recurring events of the month only.
• Add a simple additional feature to your calendar that facilitate the patterns we learn in class.
(What I want to see is the use of the strategy pattern, not how fancy the feature is.)
• The user should be able to use/test your to-do list without any user manual. That is, the
application should have a user friendly interface.
Rules
• Your project team consists of 2 members (3 member with instructor consent).
• All team members should have approximately equal work loads.
• You should not exchange project implementations with other teams.
