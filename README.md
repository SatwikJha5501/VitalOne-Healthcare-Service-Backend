# VitalOne - Healthcare Management System

VitalOne is a comprehensive healthcare management system built with Spring Boot that handles appointments, prescriptions, medicine inventory, and user management for a university healthcare facility.

## 🚀 Features

- **User Management**: Student registration and approval system
- **Appointment System**: Book and manage medical appointments
- **Appointment Requests**: Request appointments with preferred doctors and times
- **Doctor Management**: Doctor profiles with specialization and availability
- **Prescription Management**: Digital prescription system with medication tracking
- **Medicine Inventory**: Complete medicine stock management with expiry tracking
- **REST API**: Full CRUD operations for all entities

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.x
- **Database**: MySQL
- **ORM**: Hibernate/JPA
- **Validation**: Jakarta Validation
- **Build Tool**: Maven

## 📋 Prerequisites

- Java 17 or higher
- MySQL Server 8.0+
- Maven 3.6+
- Postman (for API testing)

## 🌐 API Endpoints

### User Management
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create new user
- `PUT /api/users` - Update user
- `DELETE /api/users/{id}` - Delete user

### Appointment Management
- `GET /api/appointments` - Get all appointments
- `GET /api/appointments/{id}` - Get appointment by ID
- `POST /api/appointments` - Create new appointment
- `PUT /api/appointments` - Update appointment
- `DELETE /api/appointments/{id}` - Delete appointment

### Appointment Request Management
- `GET /api/appointment-requests` - Get all appointment requests
- `GET /api/appointment-requests/{id}` - Get request by ID
- `POST /api/appointment-requests` - Create new request
- `PUT /api/appointment-requests` - Update request
- `PATCH /api/appointment-requests/{id}` - Partial update request
- `DELETE /api/appointment-requests/{id}` - Delete request

### Medicine Management
- `GET /api/medicines` - Get all medicines
- `GET /api/medicines/{id}` - Get medicine by ID
- `POST /api/medicines` - Create new medicine
- `PUT /api/medicines` - Update medicine
- `DELETE /api/medicines/{id}` - Delete medicine

### Prescription Management
- `GET /api/prescriptions` - Get all prescriptions
- `GET /api/prescriptions/{id}` - Get prescription by ID
- `POST /api/prescriptions` - Create new prescription
- `PUT /api/prescriptions` - Update prescription
- `DELETE /api/prescriptions/{id}` - Delete prescription

## 📱 Postman API Examples

### Create User
```http
POST http://localhost:8080/api/users
Content-Type: application/json

{
    "sapId": "500083168",
    "firstName": "Neelam",
    "lastName": "Bahnu",
    "batch": "B2",
    "branch": "Computer Science",
    "specialization": "Cybersecurity And Forensics",
    "email": "500083168@stu.upes.ac.in",
    "mobileNumber": "8309224251"
}
```

### Create Appointment
```http
POST http://localhost:8080/api/appointments
Content-Type: application/json

{
    "userId": 2,
    "doctorName": "Dr. Hemanth Petwal",
    "appointmentDateTime": "2024-06-16T14:00:00",
    "symptoms": "Stomach pain and nausea",
    "tags": "Routine",
    "diagnosis": "Food poisoning",
    "notes": "Prescribed medication and light diet"
}
```

### Create Medicine
```http
POST http://localhost:8080/api/medicines
Content-Type: application/json

{
    "name": "Fabiflu",
    "price": 675.00,
    "manufacturingDate": "2024-02-25",
    "expiryDate": "2025-08-25",
    "type": "TABLET",
    "description": "Antiviral medication for mild to moderate COVID-19",
    "manufacturer": "Glenmark Pharmaceuticals",
    "quantityInStock": 75,
    "batchNumber": "FAB2002024J",
    "composition": "Favipiravir 200mg",
    "uses": "Treatment of mild to moderate COVID-19 infection",
    "sideEffects": "Increased uric acid, diarrhea, liver enzyme abnormalities"
}
```

### Create Appointment Request
```http
POST http://localhost:8080/api/appointment-requests
Content-Type: application/json

{
    "userId": 5,
    "symptoms": "Ankle pain and swelling after sports injury",
    "tags": "Emergency",
    "preferredDate": "2024-06-17T11:15:00",
    "preferredDoctor": "Dr. Mohammad Ahsan",
    "additionalNotes": "Unable to bear weight on injured ankle"
}
```

### Create Prescription
```http
POST http://localhost:8080/api/prescriptions
Content-Type: application/json

{
    "userId": 3,
    "doctorId": 3,
    "prescriptionDate": "2024-02-14",
    "medications": "Amoxicillin suspension 400mg/5ml, Ibuprofen suspension 100mg/5ml",
    "dosage": "Amoxicillin: 5ml every 12 hours, Ibuprofen: 2.5ml every 6 hours as needed for fever",
    "instructions": "Shake well before use. Complete entire antibiotic course. Use measuring spoon provided, not household spoon."
}
```

## 📝 Entity Relationships

- User can have multiple Appointments and AppointmentRequests
- Doctor can be associated with multiple Appointments
- Prescription links User and Doctor with medication details
- Medicine is managed independently in inventory

## 🎯 Status Enums

### Appointment Status
- `PENDING`, `CONFIRMED`, `COMPLETED`, `CANCELLED`, `NO_SHOW`

### Appointment Request Status
- `PENDING`, `APPROVED`, `REJECTED`, `CANCELLED`

### User Status
- `PENDING`, `APPROVED`, `UNAPPROVED`

### Medicine Type
- `TABLET`, `CAPSULE`, `SYRUP`, `INJECTION`, `OINTMENT`, `DROPS`, `INHALER`, `OTHER`

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Author

Satwik Jha

