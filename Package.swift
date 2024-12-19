// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CertManager",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CertManager",
            targets: ["CertManagerPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CertManagerPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CertManagerPluginPlugin"),
        .testTarget(
            name: "CertManagerPluginPluginTests",
            dependencies: ["CertManagerPluginPlugin"],
            path: "ios/Tests/CertManagerPluginPluginTests")
    ]
)