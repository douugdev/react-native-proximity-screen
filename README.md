# react-native-proximity-screen

A JS/TS Library to programatically turn the screen off using the proximity sensor.

## Installation

```sh
npm install react-native-proximity-screen

# For older RN versions
react-native link react-native-proximity-screen
```

## Basic Usage

```js
import { startProximity, stopProximity } from 'react-native-proximity-screen';
import { useState, useEffect } from 'react';

// ...

useEffect(() => {
  if (incall) {
    startProximity();
  } else {
    stopProximity();
  }
}, []);
```

## Docs

#### _async startProximity(void)_

#### _async stopProximity(void)_

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## Special Thanks

- [Javier González](https://github.com/CabezasGonzalezJavier) for the android base.

## License

MIT
