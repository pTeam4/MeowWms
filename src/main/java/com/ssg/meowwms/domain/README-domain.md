# Domain Package

## Overview
`domain` 패키지는 애플리케이션의 비즈니스 도메인 모델을 정의하는 VO(Value Object) 클래스들을 포함합니다. 이들은 애플리케이션에서 데이터를 표현하는 가장 기본적인 객체들입니다.

## Key Components
- **VO Classes**: 데이터의 표현을 담당합니다. 이들은 비즈니스 로직을 구현하는 데 사용되며, 데이터베이스 테이블의 구조를 객체지향적으로 표현합니다.

## Best Practices
- VO 클래스는 데이터를 저장하고, 간단한 데이터 가공 로직만 포함해야 합니다.
- 데이터의 불변성을 유지하는 것이 좋습니다. 따라서, 가능하면 VO 객체를 불변 객체로 설계하세요.
