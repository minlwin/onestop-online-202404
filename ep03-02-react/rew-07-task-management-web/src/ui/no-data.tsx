export default function NoData({dataName} : {dataName : string}) {
    return (
        <div className="alert alert-info">
            There is no {dataName}. Please search again.
        </div>
    )
}