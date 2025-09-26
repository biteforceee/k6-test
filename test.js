import http from 'k6/http';
import { check } from 'k6';

export const options = {
  scenarios: {
    step1: {
      executor: 'constant-arrival-rate',
      rate: 30,
      timeUnit: '1m',
      duration: '1m',
      preAllocatedVUs: 5,
    },
    step2: {
      executor: 'constant-arrival-rate',
      rate: 60,
      timeUnit: '1m',
      startTime: '1m',
      duration: '1m',
      preAllocatedVUs: 5,
    },
    step3: {
      executor: 'constant-arrival-rate',
      rate: 90,
      timeUnit: '1m',
      startTime: '2m',
      duration: '1m',
      preAllocatedVUs: 5,
    },
  },
};

export default function() {
    const url = 'http://localhost:8080/api/insert';

    const response = http.post(url, null, {
        headers: { 'Content-Type': 'application/json' }
    });

    check(response, {
        'status is 200': (r) => r.status === 200,
        'response time < 500ms': (r) => r.timings.duration < 500,
    });
}