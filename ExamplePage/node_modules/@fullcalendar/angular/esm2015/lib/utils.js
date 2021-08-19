const hasOwnProperty = Object.prototype.hasOwnProperty;
/*
Really simple clone utility. Only copies plain arrays, objects, and Dates. Transfers everything else as-is.
Wanted to use a third-party lib, but none did exactly this.
*/
export function deepCopy(input) {
    if (Array.isArray(input)) {
        return input.map(deepCopy);
    }
    else if (input instanceof Date) {
        return new Date(input.valueOf());
    }
    else if (typeof input === 'object' && input) { // non-null object
        return mapHash(input, deepCopy);
    }
    else { // everything else (null, function, etc)
        return input;
    }
}
export function shallowCopy(val) {
    if (typeof val === 'object') {
        if (Array.isArray(val)) {
            val = Array.prototype.slice.call(val);
        }
        else if (val) { // non-null
            val = Object.assign({}, val);
        }
    }
    return val;
}
export function mapHash(input, func) {
    const output = {};
    for (const key in input) {
        if (hasOwnProperty.call(input, key)) {
            output[key] = func(input[key], key);
        }
    }
    return output;
}
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoidXRpbHMuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyIuLi8uLi8uLi8uLi9wcm9qZWN0cy9mdWxsY2FsZW5kYXIvc3JjL2xpYi91dGlscy50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDQSxNQUFNLGNBQWMsR0FBRyxNQUFNLENBQUMsU0FBUyxDQUFDLGNBQWMsQ0FBQztBQUV2RDs7O0VBR0U7QUFDRixNQUFNLFVBQVUsUUFBUSxDQUFDLEtBQUs7SUFFNUIsSUFBSSxLQUFLLENBQUMsT0FBTyxDQUFDLEtBQUssQ0FBQyxFQUFFO1FBQ3hCLE9BQU8sS0FBSyxDQUFDLEdBQUcsQ0FBQyxRQUFRLENBQUMsQ0FBQztLQUU1QjtTQUFNLElBQUksS0FBSyxZQUFZLElBQUksRUFBRTtRQUNoQyxPQUFPLElBQUksSUFBSSxDQUFDLEtBQUssQ0FBQyxPQUFPLEVBQUUsQ0FBQyxDQUFDO0tBRWxDO1NBQU0sSUFBSSxPQUFPLEtBQUssS0FBSyxRQUFRLElBQUksS0FBSyxFQUFFLEVBQUUsa0JBQWtCO1FBQ2pFLE9BQU8sT0FBTyxDQUFDLEtBQUssRUFBRSxRQUFRLENBQUMsQ0FBQztLQUVqQztTQUFNLEVBQUUsd0NBQXdDO1FBQy9DLE9BQU8sS0FBSyxDQUFDO0tBQ2Q7QUFDSCxDQUFDO0FBR0QsTUFBTSxVQUFVLFdBQVcsQ0FBQyxHQUFHO0lBQzdCLElBQUksT0FBTyxHQUFHLEtBQUssUUFBUSxFQUFFO1FBQzNCLElBQUksS0FBSyxDQUFDLE9BQU8sQ0FBQyxHQUFHLENBQUMsRUFBRTtZQUN0QixHQUFHLEdBQUcsS0FBSyxDQUFDLFNBQVMsQ0FBQyxLQUFLLENBQUMsSUFBSSxDQUFDLEdBQUcsQ0FBQyxDQUFDO1NBQ3ZDO2FBQU0sSUFBSSxHQUFHLEVBQUUsRUFBRSxXQUFXO1lBQzNCLEdBQUcscUJBQVEsR0FBRyxDQUFFLENBQUM7U0FDbEI7S0FDRjtJQUNELE9BQU8sR0FBRyxDQUFDO0FBQ2IsQ0FBQztBQUdELE1BQU0sVUFBVSxPQUFPLENBQUMsS0FBSyxFQUFFLElBQUk7SUFDakMsTUFBTSxNQUFNLEdBQUcsRUFBRSxDQUFDO0lBRWxCLEtBQUssTUFBTSxHQUFHLElBQUksS0FBSyxFQUFFO1FBQ3ZCLElBQUksY0FBYyxDQUFDLElBQUksQ0FBQyxLQUFLLEVBQUUsR0FBRyxDQUFDLEVBQUU7WUFDbkMsTUFBTSxDQUFDLEdBQUcsQ0FBQyxHQUFHLElBQUksQ0FBQyxLQUFLLENBQUMsR0FBRyxDQUFDLEVBQUUsR0FBRyxDQUFDLENBQUM7U0FDckM7S0FDRjtJQUVELE9BQU8sTUFBTSxDQUFDO0FBQ2hCLENBQUMiLCJzb3VyY2VzQ29udGVudCI6WyJcbmNvbnN0IGhhc093blByb3BlcnR5ID0gT2JqZWN0LnByb3RvdHlwZS5oYXNPd25Qcm9wZXJ0eTtcblxuLypcblJlYWxseSBzaW1wbGUgY2xvbmUgdXRpbGl0eS4gT25seSBjb3BpZXMgcGxhaW4gYXJyYXlzLCBvYmplY3RzLCBhbmQgRGF0ZXMuIFRyYW5zZmVycyBldmVyeXRoaW5nIGVsc2UgYXMtaXMuXG5XYW50ZWQgdG8gdXNlIGEgdGhpcmQtcGFydHkgbGliLCBidXQgbm9uZSBkaWQgZXhhY3RseSB0aGlzLlxuKi9cbmV4cG9ydCBmdW5jdGlvbiBkZWVwQ29weShpbnB1dCkge1xuXG4gIGlmIChBcnJheS5pc0FycmF5KGlucHV0KSkge1xuICAgIHJldHVybiBpbnB1dC5tYXAoZGVlcENvcHkpO1xuXG4gIH0gZWxzZSBpZiAoaW5wdXQgaW5zdGFuY2VvZiBEYXRlKSB7XG4gICAgcmV0dXJuIG5ldyBEYXRlKGlucHV0LnZhbHVlT2YoKSk7XG5cbiAgfSBlbHNlIGlmICh0eXBlb2YgaW5wdXQgPT09ICdvYmplY3QnICYmIGlucHV0KSB7IC8vIG5vbi1udWxsIG9iamVjdFxuICAgIHJldHVybiBtYXBIYXNoKGlucHV0LCBkZWVwQ29weSk7XG5cbiAgfSBlbHNlIHsgLy8gZXZlcnl0aGluZyBlbHNlIChudWxsLCBmdW5jdGlvbiwgZXRjKVxuICAgIHJldHVybiBpbnB1dDtcbiAgfVxufVxuXG5cbmV4cG9ydCBmdW5jdGlvbiBzaGFsbG93Q29weSh2YWwpIHtcbiAgaWYgKHR5cGVvZiB2YWwgPT09ICdvYmplY3QnKSB7XG4gICAgaWYgKEFycmF5LmlzQXJyYXkodmFsKSkge1xuICAgICAgdmFsID0gQXJyYXkucHJvdG90eXBlLnNsaWNlLmNhbGwodmFsKTtcbiAgICB9IGVsc2UgaWYgKHZhbCkgeyAvLyBub24tbnVsbFxuICAgICAgdmFsID0geyAuLi52YWwgfTtcbiAgICB9XG4gIH1cbiAgcmV0dXJuIHZhbDtcbn1cblxuXG5leHBvcnQgZnVuY3Rpb24gbWFwSGFzaChpbnB1dCwgZnVuYykge1xuICBjb25zdCBvdXRwdXQgPSB7fTtcblxuICBmb3IgKGNvbnN0IGtleSBpbiBpbnB1dCkge1xuICAgIGlmIChoYXNPd25Qcm9wZXJ0eS5jYWxsKGlucHV0LCBrZXkpKSB7XG4gICAgICBvdXRwdXRba2V5XSA9IGZ1bmMoaW5wdXRba2V5XSwga2V5KTtcbiAgICB9XG4gIH1cblxuICByZXR1cm4gb3V0cHV0O1xufVxuIl19