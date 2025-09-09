# 🎮 LoL 리뷰 플랫폼

League of Legends 소환사 리뷰 플랫폼입니다. 소환사들의 전적을 검색하고 리뷰를 작성할 수 있는 웹 애플리케이션입니다.

## 🚀 프로젝트 개요

- **목적**: LoL 소환사들의 게임 플레이에 대한 리뷰를 작성하고 공유하는 플랫폼
- **기능**: 소환사 검색, 리뷰 작성/조회, 사용자 인증
- **아키텍처**: Spring Boot + Vue.js 풀스택 웹 애플리케이션

## 🛠️ 기술 스택

### 백엔드
- **Java 17** - 최신 Java 기능 활용
- **Spring Boot 3.2.5** - 웹 애플리케이션 프레임워크
- **Spring Security 6.x** - 인증 및 보안
- **MyBatis 3.0.3** - SQL 매핑 프레임워크
- **H2 Database** - 개발용 인메모리 데이터베이스
- **JWT** - JSON Web Token 기반 인증
- **Swagger/OpenAPI** - API 문서화

### 프론트엔드
- **Vue.js 3** - 프론트엔드 프레임워크
- **Vite** - 빠른 빌드 도구
- **TailwindCSS** - 유틸리티 우선 CSS 프레임워크
- **Axios** - HTTP 클라이언트
- **Vue Router** - 클라이언트 사이드 라우팅

### 개발 도구
- **Gradle 8.14.3** - 빌드 도구
- **Cursor IDE** - 개발 환경

## 📁 프로젝트 구조

```
lol-review/
├── 📁 src/main/java/com/lolreview/summonerreview/
│   ├── 🎯 config/          # 설정 클래스들
│   ├── 🎮 controller/       # REST API 컨트롤러
│   ├── 🔧 service/         # 비즈니스 로직
│   ├── 🗄️ repository/     # 데이터 접근 계층
│   ├── 📦 dto/            # 데이터 전송 객체
│   ├── 🏛️ entity/         # 데이터베이스 엔티티
│   ├── 🛠️ util/          # 유틸리티 클래스
│   └── 🚨 exception/      # 예외 처리
├── 📁 src/main/resources/
│   ├── application.yml     # 애플리케이션 설정
│   ├── schema.sql         # 데이터베이스 스키마
│   ├── mapper/            # MyBatis SQL 매핑
│   └── static/            # 정적 파일
├── 📁 frontend/           # Vue.js 프론트엔드
└── 📁 설정 파일들
```

## 🚀 실행 방법

### 백엔드 실행
```bash
# 프로젝트 루트에서
./gradlew bootRun

# 또는
./gradlew.bat bootRun  # Windows
```

### 프론트엔드 실행
```bash
# frontend 폴더에서
cd frontend
npm install
npm run dev
```

## 🌐 접속 URL

- **메인 애플리케이션**: http://localhost:8080
- **Swagger API 문서**: http://localhost:8080/swagger-ui.html
- **H2 데이터베이스 콘솔**: http://localhost:8080/h2-console
- **프론트엔드 개발 서버**: http://localhost:5173

## 🔐 인증 시스템

- **JWT 기반 인증**: 로그인 시 JWT 토큰 발급
- **Spring Security**: 요청별 인증/인가 처리
- **BCrypt**: 비밀번호 암호화

### API 엔드포인트

- `POST /api/users/login` - 로그인
- `POST /api/users/signup` - 회원가입

## 📊 데이터베이스

### User 테이블
```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role VARCHAR(20) DEFAULT 'USER'
);
```

## 🎯 구현된 기능

### ✅ 완료된 기능
- [x] 사용자 회원가입/로그인
- [x] JWT 기반 인증 시스템
- [x] Spring Security 설정
- [x] MyBatis 데이터베이스 연동
- [x] 로그인 페이지 UI
- [x] API 문서화 (Swagger)

### 🚧 진행 예정 기능
- [ ] 리뷰 작성/조회 기능
- [ ] 소환사 검색 기능
- [ ] Riot Games API 연동
- [ ] 리뷰 평점 시스템
- [ ] 사용자 프로필 관리

## 🔧 개발 환경 설정

### Java 버전 관리
이 프로젝트는 Java 17을 사용합니다. 다른 프로젝트와의 충돌을 방지하기 위해 프로젝트별 Java 버전 설정을 적용했습니다.

- `.vscode/settings.json`: IDE별 Java 17 설정
- `gradle.properties`: Gradle 빌드 시 Java 17 강제 사용

## 📝 개발 노트

### 주요 해결 사항
1. **Java 버전 충돌**: 프로젝트별 Java 17 설정으로 해결
2. **Spring Security 403 에러**: 최신 설정 방식으로 수정
3. **MyBatis 매퍼 인식**: 의존성 및 설정 확인
4. **H2 예약어 충돌**: `user` → `users` 테이블명 변경

### 기술적 특징
- **계층형 아키텍처**: Controller → Service → Repository
- **DTO 패턴**: 데이터 전송 객체로 API 계약 명확화
- **전역 예외 처리**: `@RestControllerAdvice` 활용
- **공통 응답 형식**: `ApiResponse<T>` 표준화

## 🤝 기여하기

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다.

## 📞 연락처

프로젝트에 대한 문의사항이 있으시면 이슈를 생성해주세요.

---

**개발 시작일**: 2025년 9월 9일  
**현재 상태**: 초기 구현 완료 (v0.1.0)
