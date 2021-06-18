import * as React from 'react';

import { StyleSheet, View, Text, TouchableOpacity } from 'react-native';
import { startProximity, stopProximity } from 'react-native-proximity-screen';

export default function App() {
  React.useEffect(() => {
    startProximity();
  }, []);

  return (
    <View style={styles.container}>
      <TouchableOpacity
        onPress={() => {
          startProximity();
        }}
      >
        <Text>Start</Text>
      </TouchableOpacity>
      <TouchableOpacity
        onPress={() => {
          stopProximity();
        }}
      >
        <Text>Stop</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
