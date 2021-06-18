import { NativeModules } from 'react-native';

const { ProximityScreen } = NativeModules;

interface INativeProximityScreen {
  activateSensor(): Promise<void>;
  deactivateSensor(): Promise<void>;
}

const startProximity = async (): Promise<void> => {
  await (ProximityScreen as INativeProximityScreen).activateSensor();
};

const stopProximity = async (): Promise<void> => {
  await (ProximityScreen as INativeProximityScreen).deactivateSensor();
};

export { startProximity, stopProximity };
