import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        Main_iosKt.startKoin()
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
