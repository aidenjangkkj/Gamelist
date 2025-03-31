
---

# Gamelist

**Gamelist**는 다양한 비디오 게임 목록을 제공하고, 각 게임에 대한 상세 정보를 조회할 수 있도록 구현된 웹 애플리케이션입니다. 이 프로젝트는 백엔드에 Spring Boot를 사용하여 게임 데이터 관리 및 필터링 기능을 구현하였으며, 프론트엔드는 단순 HTML과 Thymeleaf를 사용하여 구성되었습니다.

## 프로젝트 소개

- **게임 목록 조회**: 등록된 다양한 게임들의 목록을 제공하며, 각 게임의 기본 정보를 확인할 수 있습니다.
- **게임 상세 정보**: 각 게임을 선택하면 출시일, 장르, 설명 등의 상세 정보를 제공합니다.
- **검색 및 필터링**: Spring Boot 기반의 API를 통해 게임 데이터를 검색하고 조건에 맞게 필터링할 수 있습니다.

> **참고:** 프론트엔드는 단순 HTML과 Thymeleaf를 사용하여 구현되었으며, 반응형 디자인은 적용되어 있지 않습니다.

## 기술 스택

- **프론트엔드**
  - **HTML** – 웹 페이지의 기본 구조 제공
  - **Thymeleaf** – 서버 사이드 템플릿 엔진을 통한 동적 HTML 렌더링

- **백엔드**
  - **Spring Boot** – 게임 데이터 관리 및 필터링 기능 구현
  - **Java** – 백엔드 애플리케이션 로직 구현

## 설치 및 실행 방법

### 1. 레포지토리 클론

```bash
git clone https://github.com/aidenjangkkj/Gamelist.git
cd Gamelist
```

### 2. 백엔드 실행

Spring Boot 기반의 백엔드 서버를 실행하여 게임 데이터 관리 및 필터링 기능을 활성화합니다.

- **Maven 사용 시:**

  ```bash
  mvn spring-boot:run
  ```

- **Gradle 사용 시:**

  ```bash
  ./gradlew bootRun
  ```

> **참고:** 애플리케이션은 기본 포트 8080에서 동작하며, 프론트엔드와 백엔드가 동일한 서버에서 통합되어 실행됩니다.

### 3. 애플리케이션 접속

브라우저에서 [http://localhost:8080](http://localhost:8080)을 열어 애플리케이션을 확인할 수 있습니다.

## 프로젝트 구조

```
Gamelist/
├── src/
│   ├── main/
│   │   ├── java/         # Spring Boot 애플리케이션 코드
│   │   ├── resources/
│   │   │   ├── templates/ # Thymeleaf 템플릿 파일 (HTML)
│   │   │   └── static/    # 정적 리소스 (CSS, JS, 이미지 등)
└── pom.xml or build.gradle
```

## 기여 방법

Gamelist 프로젝트에 기여하고 싶으시다면 아래 절차를 참고해주세요:

1. 이슈를 생성하여 개선 사항이나 버그를 제안합니다.
2. 새로운 기능 추가나 버그 수정을 위해 레포지토리를 포크한 후, 풀 리퀘스트(PR)를 제출합니다.
3. 코드 리뷰 후 변경 사항이 머지됩니다.

자세한 내용은 [CONTRIBUTING.md](CONTRIBUTING.md) 파일(존재하는 경우)을 참고해주세요.

## 라이선스

이 프로젝트는 [MIT 라이선스](LICENSE)를 따릅니다.

## 작성자

- [aidenjangkkj](https://github.com/aidenjangkkj)

---
