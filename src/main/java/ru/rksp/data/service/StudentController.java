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

    // Временное хранилище для демонстрации
    private StudentDataResponse lastCreatedStudent = null;

    @Override
    public ResponseEntity<StudentDataResponse> createStudentDataInData(StudentDataCreateRequest studentDataCreateRequest) {
        // Создаем запись студента
        StudentDataResponse response = new StudentDataResponse();
        response.setId(1L); // Фиксированный ID для демонстрации
        response.setFullName(studentDataCreateRequest.getFullName());
        response.setPassport(studentDataCreateRequest.getPassport());

        // Сохраняем для последующего получения
        lastCreatedStudent = response;

        return ResponseEntity.status(201).body(response);
    }

    @Override
    public ResponseEntity<StudentDataResponse> getStudentDataByIdFromData(Long id) {
        // Проверяем, что запрашиваемый ID соответствует созданной записи
        if (lastCreatedStudent != null && id.equals(lastCreatedStudent.getId())) {
            return ResponseEntity.status(200).body(lastCreatedStudent);
        } else {
            // Если запись не найдена, возвращаем 404
            return ResponseEntity.notFound().build();
        }
    }
}