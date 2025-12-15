package ru.rksp.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.rksp.data.api.StudentDataApi;
import ru.rksp.data.model.StudentDataCreateRequest;
import ru.rksp.data.model.StudentDataResponse;

@RequiredArgsConstructor
@RestController
public class StudentController implements StudentDataApi {

    // Здесь ты потом добавишь репозиторий для работы с БД
    // private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<StudentDataResponse> createStudentDataInData(StudentDataCreateRequest studentDataCreateRequest) {

        // 1. Здесь будет логика сохранения в БД, например:
        // StudentEntity newStudent = new StudentEntity();
        // newStudent.setFullName(studentDataCreateRequest.getFullName());
        // newStudent.setPassport(studentDataCreateRequest.getPassport());
        // StudentEntity savedStudent = studentRepository.save(newStudent);

        // 2. Пока просто создаем заглушку ответа, имитируя сохранение
        StudentDataResponse response = new StudentDataResponse();
        response.setId(1L); // Здесь будет savedStudent.getId()
        response.setFullName(studentDataCreateRequest.getFullName());
        response.setPassport(studentDataCreateRequest.getPassport());

        // 3. Возвращаем ответ с кодом 201 (Created)
        return ResponseEntity.status(201).body(response);
    }

    @Override
    public ResponseEntity<StudentDataResponse> getStudentDataByIdFromData(Long id) {

        // 1. Здесь будет логика поиска в БД, например:
        // Optional<StudentEntity> studentOptional = studentRepository.findById(id);
        // if (studentOptional.isEmpty()) {
        //     return ResponseEntity.notFound().build();
        // }
        // StudentEntity student = studentOptional.get();

        // 2. Пока просто проверяем заглушку
        if (id.equals(1L)) { // Здесь будет проверка studentOptional.isPresent()
            StudentDataResponse response = new StudentDataResponse();
            response.setId(id);
            response.setFullName("Иванов Иван Иванович"); // Здесь будет student.getFullName()
            response.setPassport("+7 999 123-45-67"); // Здесь будет student.getPassport()
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}