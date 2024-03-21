# Util Package

## Overview
`util` 패키지는 애플리케이션 전반에 걸쳐 사용되는 유틸리티 클래스들을 포함합니다. 이들은 특정한 작업을 보조하거나 반복되는 코드를 줄이는 데 사용되는 공통의 로직을 담고 있습니다.

## Key Components
- **String Utilities**: 문자열 처리와 관련된 유틸리티 함수들입니다. 예를 들어, 문자열 형식 변환, 검증 등의 기능을 포함할 수 있습니다.
- **Date Utilities**: 날짜와 시간 처리를 위한 유틸리티 클래스입니다. 날짜 형식 변환, 날짜 연산 등을 수행합니다.
- **File Utilities**: 파일 I/O 작업을 보조하는 유틸리티 클래스들입니다. 파일 읽기/쓰기, 파일 처리 등의 기능을 제공합니다.
- **Security Utilities**: 암호화, 토큰 생성 등 보안 관련 유틸리티 기능을 담당합니다.

## Best Practices
- 유틸리티 클래스는 상태를 가지지 않는 정적 메소드들로 구성되어야 합니다.
- 재사용 가능하고, 범용적인 기능을 유틸리티 클래스에 포함시키세요.
- 유틸리티 클래스의 메소드는 가능한 독립적으로 동작하도록 설계하세요.