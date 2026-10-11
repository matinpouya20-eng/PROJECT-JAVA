
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fileName = "university-data.ser";

        Universitysystem university;

       
        try {
            university = DataStore.load(fileName);
            System.out.println("اطلاعات دانشگاه بارگذاری شد.");

        } catch (IOException | ClassNotFoundException e) {
            university = new Universitysystem();
            System.out.println("سیستم دانشگاهی جدید ساخته شد.");
        }

       
        while (true) {

            System.out.println("\n===== سیستم مدیریت دانشگاه =====");
            System.out.println("1. نمایش کارنامه دانشجو");
            System.out.println("2. ثبت نام دانشجو در درس");
            System.out.println("3. ثبت نمره دانشجو");
            System.out.println("4. اضافه کردن دانشجو");
            System.out.println("5. اضافه کردن استاد");
            System.out.println("6. اضافه کردن درس");
            System.out.println("7. اضافه کردن کلاس");
            System.out.println("8. ارائه درس توسط استاد");
            System.out.println("9. ذخیره اطلاعات");
            System.out.println("0. ذخیره و خروج");
            System.out.print("انتخاب شما: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

               
                case "1": {

                    System.out.print("شماره دانشجویی: ");
                    String studentNumber = scanner.nextLine().trim();

                    university.printTranscript(studentNumber);
                    break;
                }

               
                case "2": {

                    System.out.print("شماره دانشجویی: ");
                    String studentNumber = scanner.nextLine().trim();

                    System.out.print("کد ارائه درس: ");
                    String offeringCode = scanner.nextLine().trim();

                    boolean result = university.enrollStudent(
                            studentNumber,
                            offeringCode
                    );

                    if (result) {
                        System.out.println("ثبت نام با موفقیت انجام شد.");
                    } else {
                        System.out.println(
                                "ثبت نام ناموفق بود؛ اطلاعات را بررسی کن."
                        );
                    }

                    break;
                }

             
                case "3": {

                    System.out.print("شماره دانشجویی: ");
                    String studentNumber = scanner.nextLine().trim();

                    System.out.print("کد ارائه درس: ");
                    String offeringCode = scanner.nextLine().trim();

                    System.out.print("نمره از 0 تا 20: ");

                    try {
                        double grade = Double.parseDouble(
                                scanner.nextLine().trim()
                        );

                        boolean result = university.recordGrade(
                                studentNumber,
                                offeringCode,
                                grade
                        );

                        if (result) {
                            System.out.println("نمره ثبت شد.");
                        } else {
                            System.out.println(
                                    "ثبت نام این دانشجو در این درس پیدا نشد."
                            );
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("نمره باید عدد باشد.");

                    } catch (IllegalArgumentException e) {
                        System.out.println(
                                "نمره باید بین صفر و بیست باشد."
                        );
                    }

                    break;
                }

            
                case "4": {

                    System.out.print("نام دانشجو: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("کد ملی: ");
                    String nationalId = scanner.nextLine().trim();

                    System.out.print("شماره دانشجویی: ");
                    String studentNumber = scanner.nextLine().trim();

                    if (name.isEmpty()
                            || nationalId.isEmpty()
                            || studentNumber.isEmpty()) {

                        System.out.println(
                                "هیچ فیلدی نباید خالی باشد."
                        );
                        break;
                    }

                    if (university.findStudentByNumber(
                            studentNumber) != null) {

                        System.out.println(
                                "این شماره دانشجویی قبلاً ثبت شده است."
                        );
                        break;
                    }

                    Student student = new Student(
                            name,
                            nationalId,
                            studentNumber
                    );

                    university.addStudent(student);

                    System.out.println("دانشجو اضافه شد.");
                    break;
                }

                
                case "5": {

                    System.out.print("نام استاد: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("کد ملی: ");
                    String nationalId = scanner.nextLine().trim();

                    System.out.print("شماره کارمندی: ");
                    String employeeNumber = scanner.nextLine().trim();

                    if (name.isEmpty()
                            || nationalId.isEmpty()
                            || employeeNumber.isEmpty()) {

                        System.out.println(
                                "هیچ فیلدی نباید خالی باشد."
                        );
                        break;
                    }

                    Teacher teacher = new Teacher(
                            name,
                            nationalId,
                            employeeNumber
                    );

                    university.addTeacher(teacher);

                    System.out.println("استاد اضافه شد.");
                    break;
                }

                
                case "6": {

                    System.out.print("کد درس: ");
                    String courseCode = scanner.nextLine().trim();

                    System.out.print("نام درس: ");
                    String courseName = scanner.nextLine().trim();

                    if (courseCode.isEmpty()
                            || courseName.isEmpty()) {

                        System.out.println(
                                "کد و نام درس نباید خالی باشند."
                        );
                        break;
                    }

                    if (university.findCourseByCode(courseCode) != null) {
                        System.out.println(
                                "این کد درس قبلاً ثبت شده است."
                        );
                        break;
                    }

                    try {
                        System.out.print("تعداد واحد: ");

                        int units = Integer.parseInt(
                                scanner.nextLine().trim()
                        );

                        if (units <= 0) {
                            System.out.println(
                                    "تعداد واحد باید بیشتر از صفر باشد."
                            );
                            break;
                        }

                        Course course = new Course(
                                courseCode,
                                courseName,
                                units
                        );

                        university.addCourse(course);

                        System.out.println("درس اضافه شد.");

                    } catch (NumberFormatException e) {
                        System.out.println(
                                "تعداد واحد باید عدد صحیح باشد."
                        );
                    }

                    break;
                }

        
                case "7": {

                    System.out.print("کد کلاس: ");
                    String classCode = scanner.nextLine().trim();

                    System.out.print("نام کلاس: ");
                    String className = scanner.nextLine().trim();

                    System.out.print("شماره اتاق: ");
                    String roomNumber = scanner.nextLine().trim();

                    if (classCode.isEmpty()
                            || className.isEmpty()
                            || roomNumber.isEmpty()) {

                        System.out.println(
                                "اطلاعات کلاس نباید خالی باشد."
                        );
                        break;
                    }

                    if (university.findClassRoom(classCode) != null) {
                        System.out.println(
                                "این کد کلاس قبلاً ثبت شده است."
                        );
                        break;
                    }

                    try {
                        System.out.print("ظرفیت کلاس: ");

                        int capacity = Integer.parseInt(
                                scanner.nextLine().trim()
                        );

                        if (capacity <= 0) {
                            System.out.println(
                                    "ظرفیت باید بیشتر از صفر باشد."
                            );
                            break;
                        }

                        ClassRoom classRoom = new ClassRoom(
                                classCode,
                                className,
                                roomNumber,
                                capacity
                        );

                        university.addClassRoom(classRoom);

                        System.out.println("کلاس اضافه شد.");

                    } catch (NumberFormatException e) {
                        System.out.println(
                                "ظرفیت باید عدد صحیح باشد."
                        );
                    }

                    break;
                }

                case "8": {

                    System.out.print("کد اختصاصی ارائه: ");
                    String offeringCode = scanner.nextLine().trim();

                    if (offeringCode.isEmpty()) {
                        System.out.println(
                                "کد ارائه نباید خالی باشد."
                        );
                        break;
                    }

                    if (university.findOfferingByCode(
                            offeringCode) != null) {

                        System.out.println(
                                "این کد ارائه قبلاً ثبت شده است."
                        );
                        break;
                    }

                    System.out.print("کد درس: ");
                    String courseCode = scanner.nextLine().trim();

                    Course course = university.findCourseByCode(
                            courseCode
                    );

                    if (course == null) {
                        System.out.println(
                                "درس پیدا نشد. ابتدا درس را اضافه کن."
                        );
                        break;
                    }

                   
                    List<Teacher> teachers = university.getTeachers();

                    if (teachers.isEmpty()) {
                        System.out.println(
                                "ابتدا حداقل یک استاد اضافه کن."
                        );
                        break;
                    }

                    System.out.println("استادهای موجود:");

                    for (int i = 0; i < teachers.size(); i++) {
                        System.out.println(
                                (i + 1) + ". "
                                + teachers.get(i).getName()
                        );
                    }

                    System.out.print("شماره استاد از فهرست بالا: ");

                    try {
                        int teacherIndex = Integer.parseInt(
                                scanner.nextLine().trim()
                        );

                        if (teacherIndex < 1
                                || teacherIndex > teachers.size()) {

                            System.out.println(
                                    "شماره استاد معتبر نیست."
                            );
                            break;
                        }

                        Teacher teacher = teachers.get(
                                teacherIndex - 1
                        );

                        System.out.print("نام ترم: ");
                        String semester = scanner.nextLine().trim();

                        if (semester.isEmpty()) {
                            System.out.println(
                                    "نام ترم نباید خالی باشد."
                            );
                            break;
                        }

                        Offering offering = new Offering(
                                offeringCode,
                                course,
                                teacher,
                                semester
                        );

                        university.addOffering(offering);

                        System.out.println(
                                "ارائه درس با موفقیت ثبت شد."
                        );

                    } catch (NumberFormatException e) {
                        System.out.println(
                                "شماره استاد باید عدد صحیح باشد."
                        );
                    }

                    break;
                }

                // ذخیره اطلاعات
                case "9": {

                    saveUniversity(university, fileName);
                    break;
                }

     
                case "0": {

                    saveUniversity(university, fileName);

                    System.out.println("برنامه بسته می‌شود.");

                    scanner.close();
                    return;
                }

                default: {
                    System.out.println(
                            "گزینه نامعتبر است؛ دوباره تلاش کن."
                    );
                }
            }
        }
    }


    private static void saveUniversity(
            Universitysystem university,
            String fileName) {

        try {
            DataStore.save(university, fileName);

            System.out.println(
                    "اطلاعات دانشگاه ذخیره شد."
            );

        } catch (IOException e) {
            System.out.println(
                    "خطا در ذخیره اطلاعات: " + e.getMessage()
            );
        }
    }
}








