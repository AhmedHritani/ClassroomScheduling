package ClassroomScheduling;


import ClassroomScheduling.Algorithms.Scheduler;
import ClassroomScheduling.Location.Auditorium;
import ClassroomScheduling.Location.Lab;
import ClassroomScheduling.Location.Location;
import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.Schedule.StudentSchedule;
import ClassroomScheduling.Schedule.TeacherSchedule;
import ClassroomScheduling.StudentsGroup.Group;
import ClassroomScheduling.StudentsGroup.Major;
import ClassroomScheduling.StudentsGroup.Section;
import ClassroomScheduling.StudentsGroup.Year;
import ClassroomScheduling.TimeSpan.TeacherTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws TimeSpan.InvalidTimeSpanException {

        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Auditorium(101, 400, "A1"));
        locations.add(new Auditorium(103, 400, "A1"));
        locations.add(new Auditorium(105, 400, "A1"));
        locations.add(new Auditorium(121, 400, "A1"));
        locations.add(new Auditorium(123, 400, "A1"));
        locations.add(new Auditorium(125, 400, "A1"));
        locations.add(new Auditorium(102, 200, "A1"));
        locations.add(new Auditorium(104, 200, "A1"));
        locations.add(new Auditorium(112, 200, "A1"));
        locations.add(new Auditorium(114, 200, "A1"));
        locations.add(new Auditorium(116, 200, "A1"));

        locations.add(new Lab(201, 50, "A1"));
        locations.add(new Lab(202, 50, "B1"));
        locations.add(new Lab(203, 50, "C1"));
        locations.add(new Lab(204, 50, "D1"));
        locations.add(new Lab(205, 50, "E1"));
        locations.add(new Lab(206, 50, "A2"));
        locations.add(new Lab(207, 50, "B2"));
        locations.add(new Lab(208, 50, "C2"));
        locations.add(new Lab(209, 50, "D2"));
        locations.add(new Lab(210, 50, "E2"));
        locations.add(new Lab(211, 50, "F2"));
        locations.add(new Lab(212, 50, "G2"));
        locations.add(new Lab(213, 50, "H2"));
        locations.add(new Lab(214, 50, "I2"));
        locations.add(new Lab(215, 50, "J2"));


        Year year4 = new Year(4000, 500, null);
        Major AIY4 = new Major(4100, 200, year4);
        Group G1AIY4 = new Group(4110, 100, AIY4);
        Group G2AIY4 = new Group(4120, 100, AIY4);
        Section S1AIY4 = new Section(4111, 50, G1AIY4);
        Section S2AIY4 = new Section(4112, 50, G1AIY4);
        Section S3AIY4 = new Section(4123, 50, G2AIY4);
        Section S4AIY4 = new Section(4124, 50, G2AIY4);

        year4.AddChild(AIY4);

        AIY4.AddChild(G1AIY4);
        AIY4.AddChild(G2AIY4);

        G1AIY4.AddChild(S1AIY4);
        G1AIY4.AddChild(S2AIY4);

        G2AIY4.AddChild(S3AIY4);
        G2AIY4.AddChild(S4AIY4);

        TeacherSchedule MohammedAlAhmedSchedule = new TeacherSchedule();
        MohammedAlAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 3.5, 0, TeacherTimeSpan.Status.COMFORTABLE));
        MohammedAlAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 3.5, (float) 4.5, 0, TeacherTimeSpan.Status.UNCOMFORTABLE));
        MohammedAlAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        MohammedAlAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        MohammedAlAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 3, TeacherTimeSpan.Status.UNAVAILABLE));
        MohammedAlAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        MohammedAlAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule NawrasWatfehSchedule = new TeacherSchedule();
        NawrasWatfehSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 4.5, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        NawrasWatfehSchedule.AddTimeSpan(new TeacherTimeSpan((float) 4.5, (float) 8.5, 0, TeacherTimeSpan.Status.COMFORTABLE));
        NawrasWatfehSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        NawrasWatfehSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        NawrasWatfehSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 3, TeacherTimeSpan.Status.UNAVAILABLE));
        NawrasWatfehSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        NawrasWatfehSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule BasilKhatibSchedule = new TeacherSchedule();
        BasilKhatibSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        BasilKhatibSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 4.5, 1, TeacherTimeSpan.Status.COMFORTABLE));
        BasilKhatibSchedule.AddTimeSpan(new TeacherTimeSpan((float) 4.5, (float) 8.5, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        BasilKhatibSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        BasilKhatibSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 3, TeacherTimeSpan.Status.UNAVAILABLE));
        BasilKhatibSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        BasilKhatibSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule AmmarNahhasSchedule = new TeacherSchedule();
        AmmarNahhasSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        AmmarNahhasSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 4.5, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        AmmarNahhasSchedule.AddTimeSpan(new TeacherTimeSpan((float) 4.5, (float) 8.5, 1, TeacherTimeSpan.Status.COMFORTABLE));
        AmmarNahhasSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        AmmarNahhasSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 3, TeacherTimeSpan.Status.UNAVAILABLE));
        AmmarNahhasSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        AmmarNahhasSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule BatoulHabboubSchedule = new TeacherSchedule();
        BatoulHabboubSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        BatoulHabboubSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 6.5, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        BatoulHabboubSchedule.AddTimeSpan(new TeacherTimeSpan((float) 6.5, (float) 8.5, 1, TeacherTimeSpan.Status.COMFORTABLE));
        BatoulHabboubSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        BatoulHabboubSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 3, TeacherTimeSpan.Status.UNAVAILABLE));
        BatoulHabboubSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        BatoulHabboubSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule LoujainSchedule = new TeacherSchedule();
        LoujainSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        LoujainSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 4.5, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        LoujainSchedule.AddTimeSpan(new TeacherTimeSpan((float) 4.5, (float) 6.5, 1, TeacherTimeSpan.Status.COMFORTABLE));
        LoujainSchedule.AddTimeSpan(new TeacherTimeSpan((float) 6.5, (float) 8.5, 1, TeacherTimeSpan.Status.UNCOMFORTABLE));
        LoujainSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        LoujainSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        LoujainSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 3, TeacherTimeSpan.Status.UNAVAILABLE));
        LoujainSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        LoujainSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule MohammedJarrahSchedule = new TeacherSchedule();
        MohammedJarrahSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        MohammedJarrahSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        MohammedJarrahSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        MohammedJarrahSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 4.5, 3, TeacherTimeSpan.Status.COMFORTABLE));
        MohammedJarrahSchedule.AddTimeSpan(new TeacherTimeSpan((float) 4.5, (float) 8.5, 3, TeacherTimeSpan.Status.UNCOMFORTABLE));
        MohammedJarrahSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        MohammedJarrahSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule AnasHaririSchedule = new TeacherSchedule();
        AnasHaririSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        AnasHaririSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        AnasHaririSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        AnasHaririSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 4.5, 3, TeacherTimeSpan.Status.UNCOMFORTABLE));
        AnasHaririSchedule.AddTimeSpan(new TeacherTimeSpan((float) 4.5, (float) 8.5, 3, TeacherTimeSpan.Status.COMFORTABLE));
        AnasHaririSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        AnasHaririSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule TSZainaDalalSchedule = new TeacherSchedule();
        TSZainaDalalSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        TSZainaDalalSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        TSZainaDalalSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        TSZainaDalalSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8.5, 3, TeacherTimeSpan.Status.COMFORTABLE));
        TSZainaDalalSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        TSZainaDalalSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule NadiaBouqaiSchedule = new TeacherSchedule();
        NadiaBouqaiSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        NadiaBouqaiSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        NadiaBouqaiSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        NadiaBouqaiSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8.5, 3, TeacherTimeSpan.Status.COMFORTABLE));
        NadiaBouqaiSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 4, TeacherTimeSpan.Status.UNAVAILABLE));
        NadiaBouqaiSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));


        TeacherSchedule MaisaaAboQasimSchedule = new TeacherSchedule();
        MaisaaAboQasimSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        MaisaaAboQasimSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        MaisaaAboQasimSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        MaisaaAboQasimSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 3, TeacherTimeSpan.Status.UNAVAILABLE));
        MaisaaAboQasimSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 4.5, 4, TeacherTimeSpan.Status.COMFORTABLE));
        MaisaaAboQasimSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));

        TeacherSchedule WasimAhmedSchedule = new TeacherSchedule();
        WasimAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 0, TeacherTimeSpan.Status.UNAVAILABLE));
        WasimAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 1, TeacherTimeSpan.Status.UNAVAILABLE));
        WasimAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 2, TeacherTimeSpan.Status.UNAVAILABLE));
        WasimAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 3, TeacherTimeSpan.Status.UNAVAILABLE));
        WasimAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 6.5, 4, TeacherTimeSpan.Status.COMFORTABLE));
        WasimAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 6.5, (float) 8.5, 4, TeacherTimeSpan.Status.UNCOMFORTABLE));
        WasimAhmedSchedule.AddTimeSpan(new TeacherTimeSpan((float) 0.5, (float) 8, 5, TeacherTimeSpan.Status.UNAVAILABLE));


        Teacher MohammedAlAhmed = new Teacher("Mohammed Al Ahmed", MohammedAlAhmedSchedule, 2, 2);
        Teacher NawrasWatfeh = new Teacher("Nawras Watfeh", NawrasWatfehSchedule, 2, 2);
        Teacher BasilKhatib = new Teacher("Basil Khatib", BasilKhatibSchedule, 2, 2);
        Teacher BatoulHabboub = new Teacher("Batoul Habboub", BatoulHabboubSchedule, 2, 2);
        Teacher Lojain= new Teacher("Lojain", LoujainSchedule, 2, 2);
        Teacher AmmarNahhas = new Teacher("Ammar Nahhas", AmmarNahhasSchedule, 2, 2);
        Teacher MohammedJarrah = new Teacher("Mohammed Jarrah", MohammedJarrahSchedule, 2, 2);
        Teacher AnasHariri = new Teacher("Anas Hariri", AnasHaririSchedule, 2, 2);
        Teacher TSZainaDalal = new Teacher("TS Zaina Dalal", TSZainaDalalSchedule, 2, 2);
        Teacher NadiaBouqai = new Teacher("Nadia Bouqai", NadiaBouqaiSchedule, 2, 2);
        Teacher MaisaaAboQasim = new Teacher("Maisaa Abo Qasim", MaisaaAboQasimSchedule, 2, 2);
        Teacher WasimAhmed = new Teacher("Wasim Ahmed", WasimAhmedSchedule, 2, 2);

        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course(400001, "Neural Networks T", MaisaaAboQasim, AIY4, 9, 2));
        courses.add(new Course(400002, "Neural Networks T", MaisaaAboQasim, AIY4, 9, 2));
        courses.add(new Course(400003, "Compiler T", BasilKhatib, AIY4, 9, 2));
        courses.add(new Course(400004, "Software Engineering T", MohammedAlAhmed, AIY4, 9, 2));
        courses.add(new Course(400005, "Finance T", NawrasWatfeh, AIY4, 9, 2));
        courses.add(new Course(400006, "Search Algorithms T", BasilKhatib, AIY4, 9, 2));
        courses.add(new Course(400007, "Operating Systems T", WasimAhmed, AIY4, 9, 2));

        courses.add(new Course(400008, "Neural Networks P", NadiaBouqai, S1AIY4, 5, 2));
        courses.add(new Course(400009, "Neural Networks P", NadiaBouqai, S2AIY4, 5, 2));
        courses.add(new Course(400010, "Neural Networks P", NadiaBouqai, S3AIY4, 5, 2));
        courses.add(new Course(400011, "Neural Networks P", NadiaBouqai, S4AIY4, 5, 2));

        courses.add(new Course(400012, "Software Engineering P", Lojain, G1AIY4, 9, 2));
        courses.add(new Course(400013, "Software Engineering P", BatoulHabboub, G2AIY4, 9, 2));

        courses.add(new Course(4000014, "Finance P", NawrasWatfeh, AIY4, 9, 2));

        courses.add(new Course(4000015, "Search Algorithms P", TSZainaDalal, S1AIY4, 9, 2));
        courses.add(new Course(4000016, "Search Algorithms P", TSZainaDalal, S2AIY4, 9, 2));
        courses.add(new Course(4000017, "Search Algorithms P", TSZainaDalal, S3AIY4, 9, 2));
        courses.add(new Course(4000018, "Search Algorithms P", TSZainaDalal, S4AIY4, 9, 2));

        courses.add(new Course(4000019, "Operating Systems P", MohammedJarrah, S1AIY4, 9, 2));
        courses.add(new Course(4000020, "Operating Systems P", MohammedJarrah, S2AIY4, 9, 2));
        courses.add(new Course(4000021, "Operating Systems P", AnasHariri, S3AIY4, 9, 2));
        courses.add(new Course(4000022, "Operating Systems P", AnasHariri, S4AIY4, 9, 2));

        courses.add(new Course(400023, "Compiler P", AmmarNahhas, G1AIY4, 9, 2));
        courses.add(new Course(400024, "Compiler P", AmmarNahhas, G2AIY4, 9, 2));

        Scheduler scheduler=new Scheduler();
        Scheduler.State state=scheduler.new State(0,0,new StudentSchedule(),courses);
        ArrayList<Scheduler.State>states=state.GetNextMoves(locations);
        for (Scheduler.State state1 : states) {
            System.out.println(state1);
        }

//        for (Scheduler.State state1 : states) {
//            state1.Print();
//        }

    }
}
