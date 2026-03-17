import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 10,
  duration: '15s',
  thresholds: {
    http_req_failed: ['rate<0.01'],
    http_req_duration: ['p(95)<800'],
  },
};

const baseUrl = __ENV.BASE_URL || 'http://localhost:8080';

export default function () {
  const response = http.get(`${baseUrl}/`);

  check(response, {
    'status 200': (r) => r.status === 200,
    'home contains title': (r) => r.body.includes('Pipeline CI/CD com Java + Maven + SonarQube'),
  });

  sleep(1);
}
