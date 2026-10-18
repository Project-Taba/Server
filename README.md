# TABA — 브레이크 오작동(급발진) 감지 & AI 기반 응급 대처 서비스
<div align="center">
   <img width="600" height="250" alt="image" src="https://github.com/user-attachments/assets/5011f9cb-7453-47d2-89c3-944e2c62d9f7" />
</div>

> **타봐! Triggered Acceleration Block Application**  
> 엑셀/브레이크 압력과 속도 데이터를 분석해 급발진을 **판단**하고, **자동으로 119에 신고**하는 스마트 모빌리티 안전 서비스.

---

## 목차(바로가기)
- [프로젝트 개요](#프로젝트-개요)
- [시스템 아키텍처](#시스템-아키텍처)
- [핵심 기능](#핵심-기능)
- [AI 분석 프로세스](#ai-분석-프로세스)
- [실험 및 시연 영상](#실험-및-시연-영상)
- [팀 소개](#팀-소개)
- [레포지토리 링크 및 설명](#레포지토리-링크-및-설명)
---

## 프로젝트 개요

- 운전자가 직접 입증해야 하는 **급발진 사고의 구조적 한계**를 데이터로 보완
- 센서 데이터(엑셀/브레이크 압력, 속도)의 **상관관계 분석**을 통해 **브레이크 오작동 여부 판단**
- 이상 징후(브레이크 오작동) 시 **AI가 즉시 119 신고 및 위치·상태 전송**으로 **골든타임 확보**

---

## 시스템 아키텍처
- **App(Flutter)** ↔ **Server(Spring Boot)** ↔ **AI(Keras)**  
- 실시간 수집 → 전처리/특징 추출 → 이상 탐지(급발진) 판별 → **119 호출** → 대시보드 기록
### 🧩 아키텍처 다이어그램

<div align="center">
<img width="1000" height="400" alt="image" src="https://github.com/user-attachments/assets/e23d4671-a34e-48cb-bcf6-749782c0d92a" />
</div>

### 📱 모바일 앱 기능 요약

<div align="center">
<img width="1000" height="400" alt="image" src="https://github.com/user-attachments/assets/88bcabf6-e3b8-4c77-9363-a9cb76d67684" />
</div>

### 🖥️ 웹 대시보드 기능 요약

<div align="center">
<img width="1000" height="400" alt="image" src="https://github.com/user-attachments/assets/e768dc56-4e9a-4f79-8402-c88947384274" />
</div>

---

## 핵심 기능

<details>
<summary>🚗 내비게이션 </summary>

<br/>
   
<div align="left">

기능 요약
1. 목적지 키워드 기반 검색
2. 목적지 최단 거리 폴리라인
3. 운행 엑셀·브레이크·속도 실시간 데이터를 통한 시각화 
   
<br/>

![Image](https://github.com/user-attachments/assets/a44ce901-8b81-4592-bf66-81dc4599b280)
<img width="280" height="500" alt="image" src="https://github.com/user-attachments/assets/aaf66319-2c86-4fa4-853e-3df636a5426f" />
</div>

</details>

<details>
<summary>🆘 AI 기반 응급 대처 </summary>

<br/>
   
<div align="left">

기능 요약
1. 모든 사용자를 위한 페달 압력 캘리브레이션(Min-Max Scaling 정규화)
2. 브레이크 오작동 감지시 119 자동 호출
3. 웹 대시보드에서 사용자 위치/상태 실시간 확인
   
<br/>

<img src="https://github.com/user-attachments/assets/f9b88307-25b6-4d23-bec2-12269a6c3ed9" width="260" height="480" />
<img src="https://github.com/user-attachments/assets/f43ac1e0-b753-474e-82d6-f80aee28236c" width="260" height="480" />
<img src="https://github.com/user-attachments/assets/b0f8fddf-a43d-40a6-aab3-db31dd54a95c" width="260" height="480" />


<img width="400" height="210" alt="image" src="https://github.com/user-attachments/assets/848d43ed-d521-406b-9fd4-99cfe19bfa0e" />
<img width="400" height="210" alt="image" src="https://github.com/user-attachments/assets/d457b3fd-9d99-467d-8dcd-c8995e393971" />

</div>

</details>


<details>
<summary>📊 이상 탐지 데이터 관리</summary>

<br/>
   
<div align="left">

기능 요약
1. 이상 탐지 전후 차량 데이터만 DB 저장  
2. 모바일 앱에 해당 데이터 차트로 제공  
3. 웹 대시보드에서 엑셀파일 다운로드  

<br/>

<img src="https://github.com/user-attachments/assets/bc65908d-2df2-4f31-ad52-2f0826b694f2" width="280" height="500" style="border-radius:10px; margin-right:10px;" />
<img src="https://github.com/user-attachments/assets/7fb6a8b4-44f4-45aa-be98-9e718d7c4a64" width="540" height="360" style="border-radius:10px;" />

</div>

</details>


<details>
<summary>⚙️ 운전 습관 측정 </summary>

<br/>
   
<div align="left">

기능 요약
1. 페달 압력, 차량 속도 기반 양발 운전·급출발·급정거 습관 제공
2. 운행 폴리 라인, 운행시간, 운행거리 제공
   
<br/>


<img src="https://github.com/user-attachments/assets/7bf0ead1-1ab6-4e45-b4a6-bed720cea792" width="280" height="500" style="border-radius:10px; margin-right:10px;" />
<img src="https://github.com/user-attachments/assets/57ddd83d-a260-41e3-bd23-ff1868c2ff7c" width="280" height="500" style="border-radius:10px; margin-right:10px;" />

</div>

</details>

---

## AI 분석 프로세스

<img width="800" height="300" alt="AI Logic Diagram" src="https://github.com/user-attachments/assets/0d8d5783-55ca-42df-be3f-6adea7bc2a9c" />

### ⚙️ 모델 개요
- 운전 중 발생하는 **엑셀 압력**, **브레이크 압력**, **속도 변화량** 데이터를 기반으로 **LSTM(Long Short-Term Memory)** 모델을 학습  
- 모든 입력값은 **Min-Max Scaling**을 통해 0~1 사이로 정규화  
- **이전 5초간의 운전 데이터(5개 샘플)** 를 입력받아,  
  **다음 1초 후의 속도 변화량**을 예측하는 구조

> LSTM은 시계열 데이터를 다루는 데 강점이 있어, 시간에 따라 변화하는 운전 패턴을 학습할 수 있습니다.

---

### 🚗 이상 탐지(급발진 감지) 로직

> 가설: "브레이크를 밟았는데 속도가 충분히 줄지 않으면 이상 상황으로 판단"

1. 차량에서 1초마다 **엑셀 압력, 브레이크 압력, 속도** 데이터를 수집  
2. 최근 5초(5개의 데이터)를 유지하며 모델에 입력  
3. 모델이 예측한 **다음 속도 변화량**과 실제 변화량을 비교  
4. 두 값의 차이가 **8(Threshold) 이상**이면 급발진으로 판단  
   - 22,000건의 정상 주행 데이터를 학습한 결과, 정규화된 이상값은 **10 이하**로 수렴  
   - OECD·ITF 기준, 속도 변화 10km/h만으로도 사고 위험률이 약 20% 감소한다는 통계 참고

---

### 🧩 설계 배경

- 동일한 압력이라도 도로 기울기나 타이어 마모 등 **물리적 환경 요인**에 따라 속도 변화가 달라질 수 있음  
- 따라서 절대적인 압력값(선형 데이터)보다는 **최근 5초간의 데이터 패턴**을 기준으로 이상 여부를 판별  
- 이 방식은 환경 요인에 대한 보정을 수행하며, LSTM이 시간의 흐름에 따른 **운전 패턴의 연속성**을 반영하여 예측할 수 있도록 설계

---

### 📈 실제 AI 이상탐지 결과

<img width="1100" height="500" alt="AI 이상탐지" src="https://github.com/user-attachments/assets/86a8bcbf-9665-4438-9677-9812b196aba1" />
  
> 빨간색은 **AI 속도 예측값과 실제 속도 차**을 나타냅니다.  
> 두 값의 차이가 8이상 벌어지는 시점을 **급발진 의심 구간**으로 판단합니다.

---

### 🔎 핵심 요약

| 구분 | 설명 |
|------|------|
| 입력 데이터 | 엑셀 압력, 브레이크 압력, 속도 변화량 |
| 입력 윈도우 | 최근 5초간 데이터 |
| 출력값 | 다음 1초 후 속도 변화량 |
| 모델 구조 | LSTM (시계열 기반 예측) |
| 판단 기준 | 예측값 - 실제값 ≥ 8 → 급발진 의심 |
| 학습 데이터 | 약 22,000건의 정상 운전 데이터 |

---

## 실험 및 시연 영상

### 🚘 하드웨어 제품 및 주행 실험
> 실제 주행 환경에서 센서·앱·AI의 연동을 검증하기 위해 실차 테스트를 진행했습니다.  

<div align="center">
   <img width="900" alt="제품 및 실험" src="https://github.com/user-attachments/assets/e5944515-c2f7-4e28-93c8-054460bddfd3" />
   <p align="center"><em>차량 내 센서 설치 및 TABA 앱 실시간 연동 장면</em></p>
</div>

<div align="center">
   <img width="800" height="300" alt="image" src="https://github.com/user-attachments/assets/95b45571-2908-4b1a-88f3-45ebb6fcb7d0" />
   <p align="center"><em> 실제 이상 탐지 감지 DB 기록 내역</em></p>
</div>

---

### 🎬 시연 영상 (App / Web / AI 통합)

| 구분 | 설명 | 링크 |
|------|------|------|
| 🚗 **AI 판단 시연** | 실제 차량 주행 중 실시간 센서·속도 연동 시연(TMap & TABA 앱 동시 실행) | [YouTube Shorts](https://youtube.com/shorts/BzHTwrxtZ7Q?feature=share) |
| 📱 **앱 데모** | Flutter 기반 실시간 주행 데이터 시각화 | [YouTube](https://www.youtube.com/watch?v=LInyRZcJ4HU) |
| 🖥️ **웹 대시보드 데모** | AI 응급대응 및 위치 모니터링 관리 화면 | [YouTube](https://www.youtube.com/watch?v=aK-eYY0P0hw) |
| ⚙️ **페달 캘리브레이션 측정** | 자동차 페달 압력 센서 값 측정 및 보정 | [YouTube Shorts](https://youtube.com/shorts/9eompbtX2hE?feature=share) |

> **시연 요약**  
> 실제 차량 환경에서 페달 센서 입력값을 기반으로 **급발진 탐지 AI 모델**을 구동하고,  
> 감지 시 **119 API 호출 → 웹 대시보드 알림 → 데이터 기록 → 앱 실시간 시각화**까지  
> 전 과정을 통합적으로 시연했습니다.

---


## 팀 소개

<table align="center">
  <tr>
    <th align="center">조창욱(팀장)</th>
    <th align="center">박창수</th>
    <th align="center">제보민</th>
    <th align="center">이진호</th>
  </tr>
  <tr>
    <td align="center"><img src="https://github.com/Chochanguk.png" width="120" height="120" style="border-radius:50%;"/></td>
    <td align="center"><img src="https://github.com/shinnyriver.png" width="120" height="120" style="border-radius:50%;"/></td>
    <td align="center"><img src="https://github.com/jebomin.png" width="120" height="120" style="border-radius:50%;"/></td>
    <td align="center"><img src="https://github.com/jinhoyoho.png" width="120" height="120" style="border-radius:50%;"/></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/Chochanguk"><img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white"/></a></td>
    <td align="center"><a href="https://github.com/shinnyriver"><img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white"/></a></td>
    <td align="center"><a href="https://github.com/jebomin"><img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white"/></a></td>
    <td align="center"><a href="https://github.com/jinhoyoho"><img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white"/></a></td>
  </tr>
  <tr>
    <td align="center">HW 제작 및 MCU 개발, 모바일 앱 개발, </br> 백엔드 API(모바일) 개발</td>
    <td align="center">아키텍처 설계, DB 설계, </br> 백엔드 API(시큐리티·웹) 개발</td>
    <td align="center">웹 대시보드 개발, 보고서 작성, </br> 선행기술 조사</td>
    <td align="center">AI 개발, 데이터 관리</td>
  </tr>
</table>




---

## 레포지토리 링크 및 설명

- **[functional_specification_web — 웹 기능 명세](https://github.com/Project-Taba/functional_specification_web)**
- **[functional_specification_app — 앱 기능 명세](https://github.com/Project-Taba/functional_specification_app)**
- **[Frontend — 웹 대시보드 (React / JavaScript)](https://github.com/Project-Taba/Frontend)**
- **[Frontend_App — 사용자 모바일 앱 (Flutter / Dart)](https://github.com/Project-Taba/Frontend_App)**
- **[Server — 백엔드 서버 (Spring Boot / Java)](https://github.com/Project-Taba/Server)**
- **[AI — 모델 / 분석 (Python / Jupyter Notebook)](https://github.com/Project-Taba/AI)**
