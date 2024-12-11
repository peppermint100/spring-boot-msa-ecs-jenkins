import http from 'k6/http';
import { sleep, check } from 'k6';

export const options = { // 성능 테스트 옵션
    stages: [
        { duration: '1s', target: 10 }, // 처음 5초간 10명의 사용자로 증가
        { duration: '5s', target: 3000 }, // 이후 20초간 30명의 사용자로 증가
        { duration: '1s', target: 10 }, // 다음 5초간 10명의 사용자로 감
    ]
}

export default function () { // 실제 성능 테스트
  let res = http.get('http://localhost:8000/pokemon-type-service/pokemon-types');
  sleep(1);
}

// export default function () { // 실제 성능 테스트
//   http.get('http://localhost:8000/pokemon-type-service/pokemon-types');
//   sleep(1);
// }
