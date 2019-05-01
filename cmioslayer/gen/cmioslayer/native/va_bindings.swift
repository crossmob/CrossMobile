import Foundation
@objc
class cmioslayer_va :NSObject {
    static func convArgs(_ values:[Any]) ->  CVaListPointer {
        var args: [CVarArg] = []
        for item in values {
            if let val = item as? NSNumber {
                let numberType = CFNumberGetType(val)
                switch numberType {
                case .sInt8Type:
                    args.append(val.int8Value)
                    break
                case .sInt16Type:
                    args.append(val.int16Value)
                    break
                case .sInt32Type:
                    args.append(val.int32Value)
                    break
                case .sInt64Type:
                    args.append(val.int64Value)
                    break
                case .float32Type:
                    args.append(val.floatValue)
                    break
                case .float64Type:
                    args.append(val.doubleValue)
                    break
                case .charType:
                    args.append(val.intValue)
                    break
                case .shortType:
                    args.append(val.intValue)
                    break
                case .intType:
                    args.append(val.intValue)
                    break
                case .longType:
                    args.append(val.int32Value)
                    break
                case .longLongType:
                    args.append(val.int64Value)
                    break
                case .floatType:
                    args.append(val.floatValue)
                    break
                case .doubleType:
                    args.append(val.doubleValue)
                    break
                case .nsIntegerType:
                    args.append(val.intValue)
                    break
                case .cgFloatType:
                    args.append(val.floatValue)
                    break
                default :
                    args.append(val)
                    break
                }
            } else if let val = item as? NSObject {
                args.append(val)
            }
        }
        return getVaList(args)
    }

	@objc
	static func NSLog_NSLog(_ format:NSString, _ va_array:[Any]) -> Void {
		NSLogv(format as String, convArgs(va_array))
	}

	@objc
	static func NSString_initWithFormat(_ format:NSString, _ locale:Any, _ va_array:[Any]) -> NSString {
		return NSString.init(format: format as String, locale:locale, arguments:convArgs(va_array))
	}

	@objc
	static func NSString_initWithFormat(_ format:NSString, _ va_array:[Any]) -> NSString {
		return NSString.init(format: format as String, arguments:convArgs(va_array))
	}

}
